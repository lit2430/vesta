package com.vesta.common.exception;

import com.vesta.common.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object obj;

    public ApiException(String message) {
        this.message = message;
    }

    public ApiException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public ApiException(ErrorCodeEnum codeEnum, String message) {
        this.code = codeEnum.getCode();
        this.message = message;
    }


    public ApiException(ErrorCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMsg();
    }


    public ApiException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }


    public ApiException(String message, Object obj) {
        this.message = message;
        this.obj = obj;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }


    public Object getObj() {
        return obj;
    }


}
