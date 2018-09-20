package com.ypacm.user.net.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Token刷新")
public class RQRefresh {

    @ApiModelProperty(required = true, value = "用户id")
    @NotNull(message = "输入信息错误")
    private long uid;

    @ApiModelProperty(required = true, value = "用户refreshtoken")
    @NotNull(message = "输入信息错误")
    @SafeHtml(message = "输入信息错误")
    private String rtk;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getRtk() {
        return rtk;
    }

    public void setRtk(String rtk) {
        this.rtk = rtk;
    }
}
