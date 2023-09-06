package com.vesta.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.vesta.common.domain.ResponseDTO;
import com.vesta.domain.ApiInfoEntity;


import java.util.Map;


public interface VestaApiService extends IService<ApiInfoEntity> {

    ResponseDTO query(String apiUrl, Map<String, Object> params);


}
