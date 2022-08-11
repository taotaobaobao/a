package com.wt.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/1 3:11 下午
 * @description：统一信息返回
 */
@Data
public class Result<T> {

    private String code;

    private String mes;

    private T data;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    public Result(ResultCodeEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.mes = resultEnum.getMes();
        this.data = data;
        this.dateTime = LocalDateTime.now();
    }

    public Result(ResultCodeEnum resultCodeEnum, T data, String mes) {
        this.code = resultCodeEnum.getCode();
        this.mes = mes;
        this.data = data;
        this.dateTime = LocalDateTime.now();
    }

    public Result(String mes, String code, T data) {
        this.code = mes;
        this.mes = code;
        this.data = data;
        this.dateTime = LocalDateTime.now();
    }


    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS, null);
    }


    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum, T data) {
        return new Result<>(resultCodeEnum, data);
    }

    public static <T> Result<T> error(String code, String mes) {
        return new Result<>(code, mes, null);
    }

    public static <T> Result<T> error() {
        return new Result<>(ResultCodeEnum.ERROR, null);
    }

    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum) {
        return error(resultCodeEnum,null);
    }


    public static <T> Result<T> error(String mes) {
        return new Result<>(ResultCodeEnum.ERROR, null, mes);
    }


    public Boolean isSuccess() {
        return this.code.equals(ResultCodeEnum.SUCCESS.getCode());
    }


}
