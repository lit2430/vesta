package com.vesta.controller;


import com.vesta.common.domain.ApiThreadLocal;
import com.vesta.common.domain.ResponseDTO;
import com.vesta.service.VestaApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "数据服务", tags = {"数据提供服务"})
@RestController
@RequestMapping("/vesta/api")
public class VestaApiController {


    @Autowired
    private VestaApiService apiService;


    @RequestMapping("query")
    @ApiOperation("查询数据统一入口")
    public ResponseDTO query() {
        ApiThreadLocal api = ApiThreadLocal.get();
        ResponseDTO result = apiService.query(api.getApiUrl(), api.getParams());
        return ResponseDTO.success(result);
    }


}
