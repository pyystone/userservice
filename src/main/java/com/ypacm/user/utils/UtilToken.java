package com.ypacm.user.utils;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
public class UtilToken {

    private static String ACCESS_SIGN_KEY   = "stone_sign_key";
    private static String REFRESH_SIGN_KEY  = "stone_refresh_sign_key";


    public static String generatorAccessToken(String userId,String pwd) {
        return UtilEncrypt.MD5(userId+pwd+System.currentTimeMillis()+ACCESS_SIGN_KEY);
    }
    public static String generatorRefreshToken(String userId,String pwd) {
        return UtilEncrypt.MD5(userId+pwd+System.currentTimeMillis()+REFRESH_SIGN_KEY);
    }

}
