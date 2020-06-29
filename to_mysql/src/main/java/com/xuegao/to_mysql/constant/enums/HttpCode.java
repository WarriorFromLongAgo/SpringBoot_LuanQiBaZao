package com.xuegao.to_mysql.constant.enums;

/**
 * @PackageName：com.fff.springbooto.constant
 * @ClassName：
 * @Description：
 * @author：
 * @date：2020/1/10 14:37
 */
public enum HttpCode {
//    package org.springframework.http.HttpStatus

//    ctrl + shift + u
    SUCCESS(200, "请求成功"),
    SYSTEM_ERROR(-1, "系统异常，请联系管理员"),
    AUTH_ERROR(1000, "认证失败"),
    LOGIN_ERROR(1001, "登录失败"),
    LOGIN_UNKNOWN_ACCOUNT(1002, "找不到用户"),
    LOGIN_INCORRECT_PSSWORD(1003, "密码错误"),
    LOGIN_LOCKED_ACCOUNT(1004, "冻结的账户"),
    LOGIN_LOGINED_ERROR(1005, "已经登录"),
    LOGIN_NOT_LOGIN_ERROR(1006, "未登录"),
    PARAM_VALIDATE_ERROR(2001, "参数校验错误"),
    SQL_ERROR(4001, "sql操作异常"),
    REDIS_ERROR(5001, "redis操作异常"),
    NULL_ERROR(7001, "系统错误:空指针异常-内存中存在调用空对象的方法"),
    FILE_ERROR(6001, "文件操作异常");

    private Integer httpCode;
    private String message;

    HttpCode(Integer httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }

    public Integer getHttpCode() {
        return this.httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
