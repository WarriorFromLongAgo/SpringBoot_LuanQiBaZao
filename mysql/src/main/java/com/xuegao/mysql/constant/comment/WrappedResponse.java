package com.xuegao.mysql.constant.comment;

import com.xuegao.mysql.constant.enums.HttpCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <br/> @PackageName：com.cherrys.schooldemo.constant.common
 * <br/> @ClassName：WrappedResponse
 * <br/> @Description：
 * <br/> @author：cherrys
 * <br/> @date：2020/7/14 10:58
 */
@ApiModel(value = "包装响应")
public class WrappedResponse<T> implements Serializable {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "错误信息描述")
    private String message;

    @ApiModelProperty(value = "返回的数据对象")
    private T data;

    private WrappedResponse() {
    }

    private WrappedResponse(T data) {
        this.code = HttpCode.SUCCESS_200.getHttpCode();
        this.message = HttpCode.SUCCESS_200.getMessage();
        this.data = data;
    }

    public WrappedResponse(String message) {
        this.message = message;
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
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> WrappedResponse<T> fail() {
        return fail(HttpCode.SERVER_ERROR.getHttpCode(), HttpCode.SERVER_ERROR.getMessage(), null);
    }

    public static <T> WrappedResponse<T> fail(String message) {
        return fail(HttpCode.SERVER_ERROR.getHttpCode(), message, null);
    }

    public static <T> WrappedResponse<T> fail(T data) {
        return fail(HttpCode.SERVER_ERROR.getHttpCode(), HttpCode.SERVER_ERROR.getMessage(), data);
    }

    public static <T> WrappedResponse<T> fail(Integer code, String message, T data) {
        return new WrappedResponse<>(code, message, data);
    }

    public static <T> WrappedResponse<T> success() {
        return success(HttpCode.SUCCESS_200.getHttpCode(), HttpCode.SUCCESS_200.getMessage(), null);
    }

    public static <T> WrappedResponse<T> success(String message) {
        return success(HttpCode.SUCCESS_200.getHttpCode(), message, null);
    }

    public static <T> WrappedResponse<T> success(T data) {
        return success(HttpCode.SUCCESS_200.getHttpCode(), HttpCode.SUCCESS_200.getMessage(), data);
    }

    public static <T> WrappedResponse<T> success(Integer code, String message, T data) {
        return new WrappedResponse<>(code, message, data);
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
