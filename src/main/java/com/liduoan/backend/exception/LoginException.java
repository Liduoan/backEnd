package com.liduoan.backend.exception;

import lombok.Data;

/**
 * @author liduoan
 * @date 2021年10月02日 22:39
 */
@Data
public class LoginException extends RuntimeException {

    private Integer code;

    private String msg;

    public LoginException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public LoginException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
