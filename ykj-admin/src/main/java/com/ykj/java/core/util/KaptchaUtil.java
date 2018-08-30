package com.ykj.java.core.util;

import com.ykj.java.config.properties.YkjProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(YkjProperties.class).getKaptchaOpen();
    }
}