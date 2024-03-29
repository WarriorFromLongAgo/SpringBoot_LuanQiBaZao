package com.xuegao.video_conver.ppt.exception;

import com.xuegao.video_conver.ppt.enums.EnumExceptionCode;

import java.util.Arrays;

/**
 *
 **/
public class Ppt2PicException extends RuntimeException {

    private int code;
    private String desc;

    public Ppt2PicException() {
    }

    public Ppt2PicException(String message) {
        super(message);
    }

    /**
     * 自定义异常
     * @param message 异常描述
     */
    public Ppt2PicException(int code, String desc, String message) {
        super(message);
        this.code = code;
        this.desc = desc;
    }

    public Ppt2PicException(EnumExceptionCode enumExceptionCode) {
        super(enumExceptionCode.getDesc());
        this.code = enumExceptionCode.getCode();
        this.desc = enumExceptionCode.getDesc();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
