package com.liduoan.backend.pojo.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 全局Json返回类
 *
 * @author liduoan
 * @date 2021年09月27日 23:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackResult<T> implements Serializable {
    private static final long serialVersionUID = 6308315887056661996L;
    private Integer code;
    private String message;
    private T data;

    public BackResult setResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        return this;
    }

    public BackResult setResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
        return this;
    }

    public static BackResult success(Object data) {
        return new BackResult().setResult(ResultCode.SUCCESS, data);
    }

    public static BackResult fail(Object data) {
        return new BackResult().setResult(ResultCode.BAD_REQUEST, data);
    }

    public static BackResult back(ResultCode code, Object data) {
        return new BackResult().setResult(code, data);
    }

}
