package com.liduoan.backend.exception;

/**
 * @author liduoan
 * @date 2021年10月02日 23:21
 */
public class AuthorizedException extends RuntimeException {

    private Integer code;

    private String msg;

    public AuthorizedException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public AuthorizedException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
