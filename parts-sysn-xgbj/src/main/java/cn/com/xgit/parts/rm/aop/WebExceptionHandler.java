package cn.com.xgit.parts.rm.aop;


import cn.com.xgit.parts.rm.exceptions.CommonPartsExceptions;
import cn.com.xgit.platform.common.result.ResultMessage;
import cn.com.xgit.platform.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 异常处理
 */
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {
    @ExceptionHandler(value = CommonPartsExceptions.class)
    public Object invoke(HttpServletRequest request, HttpServletResponse response, Exception e) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            response.setContentType("application/json;charset=utf-8");
            log.debug("", e);
            if (e instanceof CommonPartsExceptions) {
                out.write(JsonUtil.beanToJson(ResultMessage.error(e.getMessage())));
            }

            out.flush();
            out.close();
        } catch (CommonPartsExceptions ex) {
            log.info("", ex);
        } catch (Exception ex) {
            log.error("", ex);
        } finally {
            IOUtils.closeQuietly(out);
            return null;
        }
    }


}
