package com.xuegao.to_mysql.constant.enums;

public enum ResultCode {

    SUCCESS(true, 200, "操作成功！"),
    FAIL(false, 500, "操作失败"),
    UNAUTHENTICATED(false, 401, "您还未登录"),
    UNAUTHORISE(false, 401, "权限不足"),
    SERVER_ERROR(false, 5000, "抱歉，系统繁忙，请稍后重试！");

    //操作是否成功
    private boolean success;
    //操作代码
    private int code;
    //提示信息
    private String message;

    ResultCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
