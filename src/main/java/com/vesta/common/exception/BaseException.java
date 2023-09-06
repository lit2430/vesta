package com.vesta.common.exception;


import com.vesta.common.enums.ErrorCodeEnum;
import com.vesta.common.utls.MessageUtils;
import org.springframework.util.StringUtils;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String message;

    public BaseException(String module, Integer code, Object[] args, String message) {
        this.code = code;
        this.args = args;
        this.message = message;
    }

    public BaseException(String module, Integer code, Object[] args) {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage) {
        this(module, null, null, defaultMessage);
    }

    public BaseException(Integer code, Object[] args) {
        this(null, code, args, null);
    }

    public BaseException(ErrorCodeEnum errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMsg();
    }

    public BaseException(ErrorCodeEnum errorCodeEnum, Exception e) {
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMsg();
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code)) {
            message = MessageUtils.message(code, args);
        }
        if (message == null) {
            message = message;
        }
        return message;
    }


    public Integer getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getDefaultMessage() {
        return message;
    }
}
