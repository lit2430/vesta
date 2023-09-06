package com.vesta.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vesta.common.domain.ResponseDTO;
import com.vesta.common.enums.DriverTypeEnum;
import com.vesta.common.enums.ErrorCodeEnum;
import com.vesta.common.exception.ApiException;
import com.vesta.domain.ApiInfoEntity;
import com.vesta.mapper.VestaApiMapper;
import com.vesta.service.VestaApiService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class VestaApiServiceImpl extends ServiceImpl<VestaApiMapper, ApiInfoEntity> implements VestaApiService {

    @Override
    public ResponseDTO query(String apiUrl, Map<String, Object> params) {
        QueryWrapper<ApiInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("api_url", apiUrl);
        ApiInfoEntity apiInfo = this.getOne(wrapper);
        if (Objects.isNull(apiInfo)) {
            throw new ApiException(ErrorCodeEnum.API_URL_NOT_FOUND);
        }
        String driverType = apiInfo.getDriverType();
        if (Objects.equals(DriverTypeEnum.MYSQL.getName(), driverType)) {

        }


        return null;
    }
}
