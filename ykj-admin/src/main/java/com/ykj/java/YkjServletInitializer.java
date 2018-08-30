package com.ykj.java;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Cute Web程序启动类
 *
 * @author ykj
 * @date 2018-05-21 9:43
 */
public class YkjServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(YkjApplication.class);
    }
}
