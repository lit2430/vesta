package com.vesta.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("dataserver_api_info")
public class ApiInfoEntity {

    @TableField("api_id")
    private String apiId;

    @TableField("api_name")
    private String apiName;

    @TableField("api_url")
    private String apiUrl;


    @TableField("driver_type")
    private String driverType;


}
