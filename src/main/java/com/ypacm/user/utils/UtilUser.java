package com.ypacm.user.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * 用户数据工具类
 */
public class UtilUser {

    // 加密签名，用于加密密码的，从配置文件 application.properties 中读取
    @Value("${com.ypacm.user.sign}")
    private static String sign;

    /**
     * 判断是否是合法的字符串（防御XSS攻击）
     * @param data 字符串
     * @return 是否合法
     */
    private static Boolean isVaildString(String data) {
        return true;
    }

    /**
     * 判断是否是合法的email
     * @param email 邮箱
     * @return 是否合法
     */
    public static Boolean isVaildEmail(String email) {
        if (!isVaildString(email)) return false;
        return true;
    }

    /**
     * 是否是合法的密码
     * @param password 密码
     * @return 是否合法
     */
    public static Boolean isVaildPassword(String password) {
        if (!isVaildString(password)) return false;
        return true;
    }

    /**
     * 是否是合法的时间戳
     * @param ts 时间戳
     * @return 是否合法
     */
    public static Boolean isVaildTS(String ts) {
        if (!isVaildString(ts)) return false;
        return true;
    }

    /**
     * 是否是合法的随机数
     * @param r 10位随机数
     * @return 是否合法
     */
    public static Boolean isVaildR(long r) {
        return true;
    }

    /**
     * 生成服务器存储密码
     * @param password 用户上传密码
     * @return 处理以后的密码
     */
    public static String generatePassword(String password) {
        return UtilEncrypt.MD5(password + sign);
    }
}
