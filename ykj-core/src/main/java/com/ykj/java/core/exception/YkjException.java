package com.ykj.java.core.exception;

/**
 * 封装cute的异常
 *
 * @author ykj
 * @Date 2018/5/28 下午10:32
 */
public class YkjException extends RuntimeException {

    private Integer code;

    private String message;

    public YkjException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
