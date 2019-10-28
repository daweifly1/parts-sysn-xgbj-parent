package cn.com.xgit.parts.rm.common.util;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;

/**
 * 日期属性转换编辑器
 */
@Slf4j
public class DatePropertyEditor extends PropertyEditorSupport {

    private final boolean allowEmpty;

    public DatePropertyEditor(boolean allowEmpty) {
        this.allowEmpty = allowEmpty;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && !org.springframework.util.StringUtils.hasText(text)) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            try {
                setValue(new Timestamp((DateUtil.tryParse(text)).getTime()));
            } catch (Exception ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            }
        }
    }
}
