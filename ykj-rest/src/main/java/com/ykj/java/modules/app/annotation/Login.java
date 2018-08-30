package com.ykj.java.modules.app.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017/9/23 14:30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
