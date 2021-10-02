package com.liduoan.backend.exception;

import lombok.Data;

/**
 * @author liduoan
 * @date 2021年10月02日 23:19
 */
@Data
public class BaseException extends RuntimeException{

    private Integer code;

    private String msg;

    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
