package com.ypacm.user.net.response;

import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 *
 * 错误表
 *
 * 基础系统错误
 * 100001: 数据库数据缺失
 *
 * 用户相关错误
 *
 * 101001: 用户名或密码错误
 * 101002: 请重新登录
 * 101003: 信息错误
 * 101004: 该邮箱已经被注册了
 *
 *
 *
 **/

@ApiModel(value = "返回说明")
public class RSData<T> {
    public static final int OK = 0;

    @ApiModelProperty(name = "返回码", value = "返回码， 0 表示成功", dataType = "long", example = "0")
    private long code = OK;

    @ApiModelProperty(name = "描述信息", value = "描述信息", dataType = "String",example = "empty")
    private String message = "";

    private T data;

    private RSData() {
    }

    private RSData(int code) {
        this();
        this.code = code;

        this.message = messageMap.getOrDefault(code, "未定义错误信息");
    }

    private RSData(int code, String message) {
        this(code);
        this.message = message;
    }

    private RSData(T data) {
        this(OK);
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private static Map<Integer,String> messageMap = Maps.newHashMap();

    static {

        /* 系统错误 */
        messageMap.put(SystemError.SYSTEM_ERROR,             "系统错误，请联系客服");
        messageMap.put(SystemError.DATA_ERROR,               "信息错误");


        /* 用户相关错误 */
        messageMap.put(UserError.LOGIN_ERROR,                "账号 或密码错误");
        messageMap.put(UserError.RELOGIN,                    "请重新登录");
        messageMap.put(UserError.TOKEN_ERROR,                "信息错误");
        messageMap.put(UserError.HAD_REGISTER,               "该邮箱已经被注册了");
    }

    /**
     * 基础系统错误
     */
    public static class SystemError {
        /** 数据库数据缺失 */
        private static final int SYSTEM_BASE_CODE   = 100000;
        public static final int SYSTEM_ERROR = SYSTEM_BASE_CODE + 1;
        public static final int DATA_ERROR          = SYSTEM_BASE_CODE + 2;
    }

    /**
     * 用户相关错误
     *
     */
    public static class UserError {
        private static final int USER_BASE_CODE = SystemError.SYSTEM_BASE_CODE + 1000;

        /** 登录是用户密码错误 */
        public static final int LOGIN_ERROR = USER_BASE_CODE + 1;
        /** refreshtoken 过期 或 信息错误 重新登录 */
        public static final int RELOGIN = USER_BASE_CODE + 2;

        /** token过期，需要重新请求 refresh协议 通过refreshtoken 刷新token */
        public static final int TOKEN_ERROR = USER_BASE_CODE + 3;

        /** 该邮箱已经被注册了 **/
        public static final int HAD_REGISTER = USER_BASE_CODE + 4;

    }

    public static RSData buildRSData(int code) {
        return new RSData(code);
    }

    public static RSData buildRSData(int code,String message) {
        return new RSData(code,message);
    }

    public static <T> RSData<T> buildRSData(int code, Class<T> object) {
        return new RSData<>(code);
    }

    public static <T> RSData<T> buildRSData(T data) {
        return new RSData<>(data);
    }

    public static RSData buildRSData() {
        return new RSData();
    }

}
