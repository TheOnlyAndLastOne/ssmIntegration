package com.own.mvcmybatis.exception;

/**
 * @Author: zhaozhi
 * @Date: 2018/8/24 0024 13:46
 * @Description:
 */
public class MessageException extends Exception {
    private String message;

    public MessageException() {
    }

    public MessageException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
