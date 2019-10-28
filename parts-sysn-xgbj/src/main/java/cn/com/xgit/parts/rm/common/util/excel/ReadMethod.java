package cn.com.xgit.parts.rm.common.util.excel;

import cn.com.xgit.parts.rm.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Slf4j
public abstract class ReadMethod extends ReadWriteMethod {

    /**
     * 返回 Excel文件中所在的内容。
     *
     * @param currentRow 该参数指定Excel需要读取的行。
     * @param currentRow warningMessages  错误信息, key为excel行号
     * @return
     */
    public abstract Object readRow(Row currentRow, Map<Integer, String> warningMessages);

    public Date getCellDateValue(Cell cell) {
        try {
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                short format = cell.getCellStyle().getDataFormat();
                if (format == 14 || format == 31 || format == 57 || format == 58
                        || (176 <= format && format <= 178) || (182 <= format && format <= 196)
                        || (210 <= format && format <= 213) || (208 == format)) { // 日期
                    double value = cell.getNumericCellValue();
                    return org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                }
            }
            String txt = getCellValue(cell);
            return DateUtil.tryParse(txt);
        } catch (Exception e) {
            log.error("getCellDateValue error.", e);
        }
        return null;
    }


    public BigDecimal getBigDecimalValue(Cell cell) {
        try {
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                return new BigDecimal(cell.getNumericCellValue());
            }
            String txt = getCellValue(cell);
            return new BigDecimal(txt);
        } catch (Exception e) {
            log.error("getBigDecimalValue error.", e);
        }
        return null;
    }

    public String getCellValue(Cell cell) {
        String value = "";
        cell.setCellType(Cell.CELL_TYPE_STRING);
        value = cell.getStringCellValue();
        return value.trim();
    }


}
