package com.zjt.common.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            logger.info("错误码"+e.getErrorCode());
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public CommonResult han(SQLIntegrityConstraintViolationException exception){
        return CommonResult.failed(new IErrorCode() {
            @Override
            public long getCode() { return exception.getErrorCode(); }
            @Override
            public String getMessage() { return "字段名重复"+exception.getMessage(); }});

    }
}
