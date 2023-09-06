package com.vesta.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vesta.domain.ApiInfoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VestaApiMapper extends BaseMapper<ApiInfoEntity> {

}
