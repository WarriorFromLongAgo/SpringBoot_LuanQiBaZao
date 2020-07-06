package com.xuegao.to_mysql.constant.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xuegao.to_mysql.constant.enums.HttpCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "包装响应")
public class WrappedResponse<T> implements Serializable {

    @ApiModelProperty(value = "请求是否成功")
    private Boolean successful;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "错误信息描述")
    private String message;

    @ApiModelProperty(value = "返回的数据对象")
    private T data;

    private WrappedResponse() {
    }

    private WrappedResponse(T data) {
        this.successful = true;
        this.code = HttpCode.SUCCESS.getHttpCode();
        this.message = HttpCode.SUCCESS.getMessage();
        this.data = data;
    }

    public WrappedResponse(String message) {
        this.code = HttpCode.SUCCESS.getHttpCode();
        this.message = HttpCode.SUCCESS.getMessage();
    }

    public WrappedResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public WrappedResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public WrappedResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public WrappedResponse(Boolean successful, Integer code, String message, T data) {
        this.successful = successful;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static WrappedResponse fail() {
        return fail(HttpCode.SYSTEM_ERROR.getHttpCode(), HttpCode.SYSTEM_ERROR.getMessage(), null);
    }

    public static <T> WrappedResponse<T> fail(String message) {
        return new WrappedResponse<>(message);
    }

    public static <T> WrappedResponse<T> fail(Integer code, String message) {
        return new WrappedResponse<>(code, message);
    }

    public static <T> WrappedResponse<T> fail(Integer code, String message, T data) {
        return new WrappedResponse<>(code, message, data);
    }

    public static <T> WrappedResponse<T> success() {
        return new WrappedResponse<>();
    }

    // public static <T> WrappedResponse<T> success(String message) {
    //     return new WrappedResponse<>(message);
    // }

    public static <T> WrappedResponse<T> success(T data) {
        return new WrappedResponse<>(data);
    }

    @JsonIgnore
    public boolean isSuccess() {
//        Integer的 127 和 128 是两个对象，常量和变量
        return this.code.equals(HttpCode.SUCCESS.getHttpCode());
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
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
