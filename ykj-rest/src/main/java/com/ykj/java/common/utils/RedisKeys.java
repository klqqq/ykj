package com.ykj.java.common.utils;

/**
 * Redis所有Keys
 *
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
