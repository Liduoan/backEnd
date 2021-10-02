package com.liduoan.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liduoan.backend.dao.LoginDao;
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
    private LoginDao loginDao;


    @Override
    public Boolean checkUser(LoginUser user) {
        LambdaQueryWrapper<LoginUser> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(LoginUser::getUserName, user.getUserName());
        wrapper.eq(LoginUser::getPassword, user.getPassword());
        LoginUser loginUser = loginDao.selectOne(wrapper);
        return loginUser == null ? false : true;
    }

    @Override
    public Boolean register(LoginUser user) {
        //检查用户名是否存在 存在抛出异常
        //否则注册该用户
        LoginUser loginUser = loginDao.selectOne(new LambdaQueryWrapper<LoginUser>().eq(LoginUser::getUserName, user.getUserName()));
        if (loginUser!=null){
            throw new LoginException("该用户已存在");
        }
        int insert = loginDao.insert(user);
        return true;
    }
}
