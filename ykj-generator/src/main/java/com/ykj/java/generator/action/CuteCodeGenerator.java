package com.ykj.java.generator.action;


import com.ykj.java.generator.action.config.CuteGeneratorConfig;

/**
 * 代码生成器,可以生成实体,dao,service,controller,html,js
 *
 * @author ykj
 * @Date 2018/5/21 12:38
 */
public class CuteCodeGenerator {

    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
         */
        CuteGeneratorConfig cuteGeneratorConfig = new CuteGeneratorConfig();
        cuteGeneratorConfig.doMpGeneration();

        /**
         * cute的生成器:
         *      cute的代码生成器可以生成controller,html页面,页面对应的js
         */
        cuteGeneratorConfig.doCuteGeneration();
    }

}