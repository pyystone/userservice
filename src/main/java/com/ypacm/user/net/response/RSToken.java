package com.ypacm.user.net.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录接口返回的model
 */
@ApiModel(value = "登录返回参数")
public class RSToken {

    public RSToken(long uid, String tk, String rtk) {
        this.tk = tk;
        this.rtk = rtk;
        this.uid = uid;
    }

    @ApiModelProperty(name = "用户token", value = "用户token",dataType = "String",example = "202CB962AC59075B964B07152D234B70")
    private String tk;

    @ApiModelProperty(name = "用户refreshToken", value = "用户refreshToken",dataType = "String",example = "202CB962AC59075B964B07152D234B70")
    private String rtk;

    @ApiModelProperty(name = "用户id", value = "用户id",dataType = "String",example = "202CB962AC59075B964B07152D234B70")
    private long uid;

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getRtk() {
        return rtk;
    }

    public void setRtk(String rtk) {
        this.rtk = rtk;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
