package com.example.jsr356.util;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
public class RedisUtils {

    public static String genSessionKey(String qrCodeId) {
        return "session:" + qrCodeId;
    }

}
