package com.xuegao.to_mysql.constant.enums;

/**
 * @PackageName：com.fff.springbooto.constant
 * @ClassName：
 * @Description：
 * @author：
 * @date：2020/1/10 16:18
 */
public enum ResponseCode {

    // 系统模块
    SUCCESS(0, "操作成功"),
    ERROR(1, "操作失败"),
    SERVER_ERROR(500, "服务器异常"),

    // 通用模块 1xxxx
    ILLEGAL_PARAMETER(10000, "参数非法"),
    REPETITIVE_OPERATION(10001, "请勿重复操作"),
    REQUEST_TO_MUCH(10002, "请求太频繁, 请稍后再试"),
    MAIL_SEND_SUCCESS(10003, "邮件发送成功"),

    // 用户模块 2xxxx
    LOGIN_FAIL(20001, "登录失效"),
    USERNAME_OR_PASSWORD_EMPTY(20002, "用户名或密码不能为空"),
    USERNAME_OR_PASSWORD_ERROR(20003, "用户名或密码错误"),
    USER_NOT_EXISTS(20004, "用户不存在"),
    PASSWORD_ERROR(20005, "密码错误"),

    ;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
