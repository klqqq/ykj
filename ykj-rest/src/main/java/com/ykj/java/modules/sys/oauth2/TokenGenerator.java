package com.ykj.java.modules.sys.oauth2;

import com.ykj.java.common.exception.YkjException;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 生成token
 *
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-05-20 14:41
 */
public class TokenGenerator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (java.lang.Exception e) {
            throw new YkjException("生成Token失败", e);
        }
    }
}
