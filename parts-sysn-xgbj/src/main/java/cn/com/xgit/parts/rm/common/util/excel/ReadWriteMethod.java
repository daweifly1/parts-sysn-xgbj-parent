package cn.com.xgit.parts.rm.common.util.excel;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;


public class ReadWriteMethod {
    /**
     * 判断excel 的格式是否为空
     *
     * @param cell
     * @return
     */
    protected boolean isBlank(Cell cell) {
        if (cell == null) {
            return true;
        }
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            String stringCellValue = cell.getStringCellValue();
            return StringUtils.isBlank(stringCellValue);
        }
        return false;
    }

    /**
     * 判断是否String 和基本包装类别
     *
     * @param clazz
     * @return
     */
    protected boolean isWrapType(Class clazz) {
        if (clazz == String.class) {
            return true;
        }
        try {
            return ((Class) clazz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }
}
