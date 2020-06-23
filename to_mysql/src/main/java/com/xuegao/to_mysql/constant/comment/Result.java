package com.xuegao.to_mysql.constant.comment;

import com.xuegao.to_mysql.constant.enums.ResultCode;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.constant.comment
 * <br/> @ClassName：Result
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 15:06
 */
public class Result<T> {
    //是否成功
    private boolean success;
    // 返回码
    private Integer code;
    //返回信息
    private String message;
    // 返回数据
    private T data;

    private Result(ResultCode code) {
        this.success = code.success();
        this.code = code.code();
        this.message = code.message();
    }

    public Result(T data) {
        this.success = ResultCode.SUCCESS.success();
        this.code = ResultCode.SUCCESS.code();
        this.message = ResultCode.SUCCESS.message();
        this.data = data;
    }

    public Result(ResultCode code, T data) {
        this.success = code.success();
        this.code = code.code();
        this.message = code.message();
        this.data = data;
    }

    public Result(ResultCode code, String message, T data) {
        this.code = ResultCode.SUCCESS.code();
        this.message = message;
        this.success = code.success();
        this.data = data;
    }

    public Result(Integer code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static <T> Result<T> succsess() {
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> succsess(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> succsess(String message, T data) {
        return new Result<>(ResultCode.SUCCESS, message, data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ResultCode.FAIL);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultCode.FAIL, data);
    }

    public static <T> Result<T> fail(String message, T data) {
        return new Result<>(ResultCode.FAIL, message, data);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}