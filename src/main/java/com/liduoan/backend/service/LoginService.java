package com.liduoan.backend.service;

import com.liduoan.backend.pojo.entity.LoginUser;

public interface LoginService {
    /**
     * 检查用户密码是否正确
     */
    Boolean checkUser(LoginUser user);

    /**
     * 注册用户
     */
    Boolean register(LoginUser user);
}
