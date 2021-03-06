package com.liduoan.backend.config;

import com.liduoan.backend.exception.AuthorizedException;
import com.liduoan.backend.exception.LoginException;
import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.pojo.entity.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liduoan
 * @date 2021年10月02日 22:42
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 登录异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(LoginException.class)
    public BackResult loginExceptionHandler(LoginException exception) {
        return BackResult.back(ResultCode.LOGIN_FAIL, exception.getMsg());
    }


    @ExceptionHandler(AuthorizedException.class)
    public BackResult authorizedExceptionHandler(AuthorizedException exception) {
        return BackResult.back(ResultCode.UNAUTHORIZED, exception.getMsg());
    }


    /**
     * 通用异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BackResult exceptionHandler(Exception exception) {
        return BackResult.back(ResultCode.FAIL, exception.getMessage());
    }
}
