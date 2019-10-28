package cn.com.xgit.parts.rm.common.util.excel;

import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class WriteMethod<T> extends ReadWriteMethod {
    protected Map<Integer, List<String>> data = new HashMap<>();

    public WriteMethod(List<T> needAddData, Class<T> clazz) throws IllegalAccessException {
        writeMethod(needAddData, clazz);
    }

    /**
     * 如果默认导出不符合，子类重写该方法
     *
     * @param needAddData
     * @param clazz
     * @throws IllegalAccessException
     */
    protected void writeMethod(List<T> needAddData, Class<T> clazz) throws IllegalAccessException {
        boolean isWrap = isWrapType(clazz);
        Field[] fieldArray = clazz.getDeclaredFields();
        if (CollectionUtils.isNotEmpty(needAddData) && fieldArray != null && fieldArray.length > 0) {
            int i = 0;
            for (T obj : needAddData) {
                List<String> rowData = new ArrayList<>();
                for (Field field : fieldArray) {
                    if (isWrap) {
                        rowData.add(String.valueOf(obj));
                    } else {
                        field.setAccessible(true);
                        Object value = field.get(obj);
                        if (value != null) {
                            rowData.add(value + "");
                        } else {
                            rowData.add("");
                        }
                    }
                }
                data.put(i++, rowData);
            }
        }
    }

    /**
     * 返回 Map<Integer,List<String>>
     *
     * @param
     * @return
     */
    public final Map<Integer, List<String>> getData() {
        return data;
    }

}
