package com.shin.shinxbgalleryweb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import result.BusinessCode;
import result.ServiceResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于@ControllerAdvice注解的全局异常统一处理只能针对于Controller层的异常
 * 为了和Controller 区分 ，我们可以指定 annotations = RestController.class，那么在Controller中抛出的异常 这里就不会被捕捉
 * */
@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionController {

    /**
     * 处理所有的Controller层面的异常
     * */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ServiceResult handleAllExceptions(Exception ex, WebRequest request){
        log.error(ex.getMessage());
        return ServiceResult.failure(BusinessCode.server_issues.getCode(),ex.getLocalizedMessage());
    }
}