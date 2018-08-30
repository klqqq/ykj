package com.ykj.java.core.exception;

/**
 * 抽象接口
 *
 * @author ykj
 * @date 2018-5-28-下午10:27
 */
public interface ServiceExceptionEnum {

    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();
}
