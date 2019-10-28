//package cn.com.xgit.parts.rm.aop.aspect;
//
//import cn.com.xgit.platform.captcha.autoconfigure.entity.CaptchaEntity;
//import cn.com.xgit.platform.captcha.autoconfigure.exception.ValidateCaptchaException;
//import cn.com.xgit.platform.common.result.ResultMessage;
//import cn.com.xgit.platform.common.util.CommonUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//
//
//@Slf4j
//@Aspect
//@Component
//public class ControllerAspect {
//
//
//    @Pointcut("this(cn.com.xgit.platform.common.base.controller.BaseController)&&@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    public void aspect() {
//    }
//
//    @Around("aspect()")
//    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object result = null;
//        try {
//            if (kaptchaConfig.isValidate() && validCaptcha(CommonUtils.getHttpRequest()))
//                result = joinPoint.proceed();
//        } catch (ValidateCaptchaException e) {
//            log.info("验证码异常：{}", e.getMessage());
//            CommonUtils.responseJson(ResultMessage.error(1, e.getMessage()));
//        }
//        return result;
//    }
//
//
//}
