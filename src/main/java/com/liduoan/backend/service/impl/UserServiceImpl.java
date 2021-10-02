package com.liduoan.backend.service.impl;

import com.liduoan.backend.dao.UserMapper;
import com.liduoan.backend.pojo.entity.User;
import com.liduoan.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liduoan
 * @date 2021年09月28日 22:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer save(User user) {
        return userMapper.insert(user);
    }


}
