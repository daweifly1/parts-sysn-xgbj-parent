package cn.com.xgit.parts.rm.common.util.excel;

import cn.com.xgit.parts.rm.exceptions.CommonPartsExceptions;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExcelFileUtil {


    /**
     * Excel导入
     *
     * @param multipartHttpServletRequest
     * @param reader
     * @param excelHeaderTitle
     * @return
     */
    public static Map<String, Object> read(MultipartHttpServletRequest multipartHttpServletRequest, ReadMethod reader, ExcelFileConstant.ExcelHeader excelHeaderTitle) {
        MultipartFile multipartFile = null;
        if (multipartHttpServletRequest != null) {
            multipartFile = multipartHttpServletRequest.getFile("file");
        }
        return readCore(multipartFile, reader, excelHeaderTitle);
    }

    private static Map<String, Object> readCore(MultipartFile multipartFile, ReadMethod reader, ExcelFileConstant.ExcelHeader excelHeaderTitle) {
        Workbook workbook;
        String fileName;

        InputStream inputStream;
        Map<String, Object> ret = new HashMap<>();
        Map<Integer, String> warningMessages = new HashMap<>();
        List<Object> data = new ArrayList<>();
        try {
            if (multipartFile == null || multipartFile.isEmpty()) {
                log.error("ExcelFileUtil:read 上传的文件无效!");
                throw new CommonPartsExceptions("上传的文件无效!");
            }
            inputStream = multipartFile.getInputStream();
            fileName = multipartFile.getOriginalFilename();
            if (fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                log.info("ExcelFileUtil:read 上传文件的类型错误!");
                throw new CommonPartsExceptions("上传文件的类型错误!");
            }
            Sheet sheet = workbook.getSheetAt(0);
            if (!validateExcel(sheet, excelHeaderTitle)) {
                throw new CommonPartsExceptions("上传的文件无效!");
            }

            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            for (int i = firstRow + 1; i <= lastRow; i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    break;
                }
                if (!isBlankRow(currentRow, excelHeaderTitle)) {
                    Object rowData = reader.readRow(currentRow, warningMessages);
                    if (warningMessages.get(currentRow.getRowNum()) == null && rowData != null) {
                        data.add(rowData);
                    }
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            log.error("ExcelFileUtil read " + e.getMessage());
            throw new CommonPartsExceptions(e.getMessage());
        }
        ret.put(ExcelFileConstant.DATA_LIST, data);
        List<String> warningMessageList = new ArrayList<>(warningMessages.values());
        // 若要结合service层校验的将错误信息汇总排序需要使用rownum
        ret.put(ExcelFileConstant.ROW_WARNING_MESSAGES, warningMessages);
        ret.put(ExcelFileConstant.WARNING_MESSAGES, warningMessageList);
        return ret;
    }


    /**
     * 导出Excel文件
     *
     * @param response
     * @param writer
     * @param excelHeaderTitle
     * @return
     * @author hzzhuqi1<hzzhuqi1 @ corp.neteaese.com>
     */
    public static void write(HttpServletResponse response, WriteMethod writer,
                             ExcelFileConstant.ExcelHeader excelHeaderTitle, String exportFileName) {
        Result result = null;
        FileInputStream fileInputStream = null;
        try {
            result = writeCore(writer, excelHeaderTitle);
            fileInputStream = new FileInputStream(result.getTarget());
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((exportFileName + ".xlsx").getBytes("gb2312"), "ISO8859-1"));
            IOUtils.copy(fileInputStream, response.getOutputStream());
        } catch (IOException e) {
            log.error("ExcelFileUtil write " + e.getMessage());
            throw new CommonPartsExceptions("ExcelFileUtil read" + e);
        } finally {
            try {
                if (result != null) {
                    result.getWorkbook().close();
                    FileUtils.forceDelete(result.getTarget());
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                response.getOutputStream().close();
            } catch (IOException e) {
                log.error("ExcelFileUtil write " + e.getMessage());
            }
        }
    }


    private static Result writeCore(WriteMethod writer, ExcelFileConstant.ExcelHeader excelHeaderTitle) {
        String tmp = ExcelFileUtil.class.getResource("/").getPath() + File.separator + "tmp/";
        File dir = new File(tmp);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = tmp + excelHeaderTitle.name() + ".xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");
        sheet.setDefaultColumnWidth(13);
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFRow row = sheet.createRow(0);
        List<String> headers = ExcelFileConstant.header.get(excelHeaderTitle);
        for (int i = 0; i < headers.size(); i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(headers.get(i));
        }
        Map<Integer, List<String>> data = Maps.newHashMap();
        if (writer != null) {
            data = writer.getData();
        }
        if (MapUtils.isNotEmpty(data)) {
            for (int k = 0; k < data.size(); k++) {
                List<String> rowData = data.get(k);
                XSSFRow dataRow = sheet.createRow(k + 1);
                if (CollectionUtils.isEmpty(rowData)) {
                    continue;
                }
                for (int i = 0; i < headers.size(); i++) {
                    String colData = rowData.get(i);
                    if (StringUtils.isNotBlank(colData) && !"".equals(StringUtils.trim(colData))) {
                        XSSFCell cell = dataRow.createCell(i);
                        cell.setCellStyle(style);
                        cell.setCellValue(colData);
                    }
                }
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            log.error("ExcelFileUtil-writeCore error", e);
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    log.error("ExcelFileUtil-writeCore error", e);
                }
            }
        }
        File target = new File(fileName);
        return new Result(target, workbook, new File(tmp));
    }


    /**
     * 验证是否是空行，若是返回true，否则false
     *
     * @param currentRow
     * @return
     */
    private static boolean isBlankRow(Row currentRow, ExcelFileConstant.ExcelHeader headerTitle) {
        int lastColumn = ExcelFileConstant.header.get(headerTitle).size();
        for (int currentCol = 0; currentCol < lastColumn; currentCol++) {
            Cell cell = currentRow.getCell(currentCol);
            if (cell != null) {
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                String value = cell.getStringCellValue();
                if (StringUtils.isNotBlank(value.trim())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 验证Excel 文件指定sheet的内容。该方法会在readRow之前调用。
     *
     * @param sheet
     * @return
     */
    private static boolean validateExcel(Sheet sheet, ExcelFileConstant.ExcelHeader headerTitle) {
        boolean ret = true;
        List<String> excelHeader = ExcelFileConstant.header.get(headerTitle);
        if (sheet == null) {
            return false;
        }
        Row header = sheet.getRow(0);
        if (header == null) {
            return false;
        }
        Iterator<Cell> cellIterator = header.cellIterator();
        List<String> realHeader = new ArrayList<>();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            realHeader.add(cell.getStringCellValue());
        }
        if (realHeader.size() != excelHeader.size()) {
            return false;
        }
        for (int i = 0; i < excelHeader.size(); i++) {
            if (null == realHeader.get(i)) {
                return false;
            }
            if (!realHeader.get(i).startsWith(excelHeader.get(i))) {
                log.error("excel模板头行参数与给定模板不一致");
                return false;
            }
        }
        if (sheet.getPhysicalNumberOfRows() <= 1) {
            ret = false;
        }
        return ret;
    }

    private static class Result {
        /**
         * 目标文件
         */
        private File target;
        /**
         * EXcel 对象
         */
        private Workbook workbook;
        /**
         * 文件目录
         */
        private File dir;

        Result(File target, XSSFWorkbook workbook, File dir) {
            this.target = target;
            this.workbook = workbook;
            this.dir = dir;
        }

        public File getTarget() {
            return target;
        }

        public Workbook getWorkbook() {
            return workbook;
        }

        public File getDir() {
            return dir;
        }
    }


}
