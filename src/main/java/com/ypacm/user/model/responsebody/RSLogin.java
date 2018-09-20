package com.ypacm.user.model.responsebody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * 登录接口返回的model
 */
@ApiModel(value = "登录返回参数")
public class RSLogin {

    public RSLogin(String tk, String rtk) {
        this.tk = tk;
        this.rtk = rtk;
    }

    @ApiModelProperty(value = "用户token",dataType = "String",example = "202CB962AC59075B964B07152D234B70")
    private String tk;

    @ApiModelProperty(value = "refreshToken",dataType = "String",example = "202CB962AC59075B964B07152D234B70")
    private String rtk;
}
