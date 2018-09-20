package com.ypacm.user.model.responsebody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */

@ApiModel(value = "返回说明")
public class RSData<T> {
    public static final long OK = 0;
    public static final long ERROR = -1;

    @ApiModelProperty(value = "返回码， 0 表示成功", dataType = "long")
    private long code;

    @ApiModelProperty(value = "描述信息", dataType = "String")
    private String message;

    private T data;

    public RSData() {
        this.code = OK;
        this.message = "";
    }

    public RSData(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public RSData(T data) {
        this.code = OK;
        this.message = "";
        this.data = data;
    }

}
