package cn.com.xgit.parts.rm.aop;


import cn.com.xgit.platform.common.result.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Spring Validation校验异常处理
 */
@RestControllerAdvice
@Slf4j
public class WebBindExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultMessage bindException(MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();

        String errorMesssage = "校验失败:";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + ", ";
        }
        return  ResultMessage.error(errorMesssage);
    }


}
