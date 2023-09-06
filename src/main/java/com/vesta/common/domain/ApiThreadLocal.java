package com.vesta.common.domain;


import lombok.Data;

import java.util.Map;

@Data
public class ApiThreadLocal {

    private static final ThreadLocal<ApiThreadLocal> localThread = new ThreadLocal<>();

    private String apiUrl;

    private Map<String, Object> params;


    public ApiThreadLocal(String apiUrl, Map<String, Object> params) {
        this.apiUrl = apiUrl;
        this.params = params;
    }

    public void set() {
        localThread.set(this);
    }


    public static ApiThreadLocal get() {
        return localThread.get();
    }


}
