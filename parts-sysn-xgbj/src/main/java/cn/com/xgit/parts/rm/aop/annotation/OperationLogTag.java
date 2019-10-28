package cn.com.xgit.parts.rm.aop.annotation;


import cn.com.xgit.parts.rm.aop.annotation.enums.LogTypeEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定方法被访问时候，保存操作日志，限制该注解仅用于controller中
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface OperationLogTag {
    /**
     * 日志类型，默认普通访问类型
     *
     * @return
     */
    LogTypeEnum logType() default LogTypeEnum.COMMON;

    String description() default "";
}
