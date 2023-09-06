package com.vesta.common.domain;

import com.vesta.common.enums.ErrorCodeEnum;
import lombok.Data;

@Data
public class ResponseDTO<T> {

    private Integer code;

    private String msg;

    private T data;

    private ResponseDTO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResponseDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO(ErrorCodeEnum.SUCCESS.getCode(), "success", data);
    }

    public static <T> ResponseDTO<T> success() {
        return new ResponseDTO(ErrorCodeEnum.SUCCESS.getCode(), "success");
    }

    public static <T> ResponseDTO<T> fail(int status, String message) {
        return new ResponseDTO(status, message);
    }

    public static <T> ResponseDTO<T> fail(String message) {
        return new ResponseDTO(ErrorCodeEnum.FAIL.getCode(), message);
    }


}

