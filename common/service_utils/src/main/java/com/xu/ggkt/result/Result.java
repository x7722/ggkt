package com.xu.ggkt.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一结果返回类
 */
@Data
public class Result<T> {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;


    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("成功!");
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> ok(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        if (message == null || "".equals(message)) {
            result.setMessage("成功!");
        } else {
            result.setMessage(message);
        }
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> fail(T data) {
        Result<T> result = new Result<>();
        result.setCode(201);
        result.setMessage("失败!");
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> fail(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(201);

        if (message == null || "".equals(message)) {
            result.setMessage("失败!");
        } else {
            result.setMessage(message);
        }
        if (data != null) {
            result.setData(data);
        }
        return result;
    }


}
