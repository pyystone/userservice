package com.ypacm.user.error;

import com.google.common.collect.Maps;
import com.ypacm.user.model.responsebody.RSData;

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
 */
public class ExceptionFormat {


    private static Map<Integer,String> messageMap = Maps.newHashMap();

    static {

        /* 系统错误 */
        messageMap.put(System.DATA_ERROR,               "系统错误，请联系客服");


        /* 用户相关错误 */
        messageMap.put(User.LOGIN_ERROR,                "用户名或密码错误");
        messageMap.put(User.RELOGIN,                    "请重新登录");
        messageMap.put(User.TOKEN_ERROR,                "信息错误");
        messageMap.put(User.HAS_REGISTER,               "该邮箱已经被注册了");
    }

    /**
     * 基础系统错误
     */
    public static class System {
        /** 数据库数据缺失 */
        private static final int SYSTEM_BASE_CODE   = 100000;
        public static final int DATA_ERROR          = SYSTEM_BASE_CODE + 1;
    }

    /**
     * 用户相关错误
     *
     */
    public static class User {
        private static final int USER_BASE_CODE = System.SYSTEM_BASE_CODE + 1000;

        /** 登录是用户密码错误 */
        public static final int LOGIN_ERROR = USER_BASE_CODE + 1;
        /** refreshtoken 过期 或 信息错误 重新登录 */
        public static final int RELOGIN = USER_BASE_CODE + 2;

        /** token过期，需要重新请求 refresh协议 通过refreshtoken 刷新token */
        public static final int TOKEN_ERROR = USER_BASE_CODE + 3;

        /** 该邮箱已经被注册了 **/
        public static final int HAS_REGISTER = USER_BASE_CODE + 4;

    }

    public static <T> RSData<T> builderErrorResult(long code, Class<T> object) {
        return new RSData<>(code, messageMap.get(code));
    }
}
