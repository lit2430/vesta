package com.vesta.common.enums;

/**
 * 错误码集合
 */
public enum ErrorCodeEnum {


    // -------------- 普通错误码 及保留错误码 ---------------
    SUCCESS(200, "操作成功"),
    FAIL(9999, "操作失败"),
    DRUID_DATASOURCE_INIT_FAILED(50001, "Druid datasource init failed"),
    DRUID_JDBC_CONNECT_OBTAIN_FAILED(50002, "Druid jdbc connect obtain failed"),
    QUERY_SQL_RESULT_ERROR(50003, "Query sql result error"),


    //------------------
    API_URL_NOT_FOUND(60001, "Api url not found ");


    private final int code;
    private final String msg;


    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
