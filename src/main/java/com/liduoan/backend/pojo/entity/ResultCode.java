package com.liduoan.backend.pojo.entity;

/**
 * 返回码
 *
 * @author liduoan
 * @date 2021年09月27日 23:05
 */
public enum ResultCode {
    SUCCESS(200, "成功"),//成功
    //FAIL(400, "失败"),//失败
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "认证失败"),//未认证
    NOT_FOUND(404, "接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "系统繁忙"),//服务器内部错误
    METHOD_NOT_ALLOWED(405,"方法不被允许"),

    //认证的返回码
    JWT_ERRCODE_EXPIRE(4003,"认证已过期"),
    JWT_ERRCODE_FAIL(4004,"认证失败"),
    /*参数错误:1001-1999*/
    PARAMS_IS_INVALID(1001, "参数无效"),
    PARAMS_IS_BLANK(1002, "参数为空");
    /*用户错误2001-2999*/


    private Integer code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
