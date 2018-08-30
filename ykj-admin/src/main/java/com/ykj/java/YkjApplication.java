package com.ykj.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * SpringBoot方式启动类
 *
 * @author ykj
 * @Date 2018/5/21 12:06
 */
@SpringBootApplication
public class YkjApplication {

    private final static Logger logger = LoggerFactory.getLogger(YkjApplication.class);
    @Resource
    private Environment env;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(YkjApplication.class);
        final ApplicationContext applicationContext = app.run(args);
        Environment env = applicationContext.getEnvironment();

        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t ----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"));
    }
}
