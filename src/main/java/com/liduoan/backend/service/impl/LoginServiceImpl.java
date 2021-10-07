package com.liduoan.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liduoan.backend.dao.LoginMapper;
import com.liduoan.backend.exception.LoginException;
import com.liduoan.backend.pojo.entity.LoginUser;
import com.liduoan.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liduoan
 * @date 2021年10月02日 18:15
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;


    @Override
    public Boolean checkUser(LoginUser user) {
        LambdaQueryWrapper<LoginUser> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(LoginUser::getUsername, user.getUsername());
        wrapper.eq(LoginUser::getPassword, user.getPassword());
        LoginUser loginUser = loginMapper.selectOne(wrapper);
        if (loginUser == null) {
            throw new LoginException("用户名或密码错误");
        }
        return true;
    }

    @Override
    public Boolean register(LoginUser user) {
        //检查用户名是否存在 存在抛出异常
        //否则注册该用户
        LoginUser loginUser = loginMapper.selectOne(
                new LambdaQueryWrapper<LoginUser>().eq(LoginUser::getUsername, user.getUsername()));
        if (loginUser != null) {
            return false;
        }
        loginMapper.insert(user);
        return true;
    }
}
