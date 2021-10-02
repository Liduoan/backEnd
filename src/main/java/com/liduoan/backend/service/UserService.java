package com.liduoan.backend.service;

import com.liduoan.backend.pojo.entity.User;

public interface UserService {

    /**
     * 保存用户信息
     * */
    Integer save(User user);
}
