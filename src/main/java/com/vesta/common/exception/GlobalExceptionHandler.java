package com.vesta.common.exception;

import com.vesta.common.domain.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(BaseException.class)
    public ResponseDTO baseException(BaseException e) {
        return ResponseDTO.fail(e.getMessage());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseDTO handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseDTO.fail(HttpStatus.NOT_FOUND.value(), "路径不存在，请检查路径是否正确");
    }

    /**
     * 系统异常捕获处理
     */
    @ExceptionHandler(Throwable.class)
    public ResponseDTO handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseDTO.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务异常");
    }


    /**
     * 数据服务异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ApiException.class)
    public ResponseDTO apiException(ApiException e) {
        log.error(e.getMessage(), e);
        return ResponseDTO.fail(e.getCode(), e.getMessage());
    }


}
