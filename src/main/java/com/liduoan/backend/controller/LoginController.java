package com.liduoan.backend.controller;

import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.pojo.entity.LoginUser;
import com.liduoan.backend.service.LoginService;
import com.liduoan.backend.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * @author liduoan
 * @date 2021年10月02日 18:08
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/check")
    public BackResult login(@RequestBody LoginUser user) {
        //查看该用户是否登录成功
        loginService.checkUser(user);
        String token = null;
        try {
            token = JwtUtil.createJWT(String.valueOf(new Date()), user.getUsername(), 360000000000L);
        } catch (IOException e) {
            log.error("token 获取异常:{}", e.getMessage());
        }
        return BackResult.success(token);
    }


    @PostMapping("/register")
    public BackResult register(@RequestBody LoginUser user) {
        //注册该用户 要求这个用户的用户名唯一
        Boolean register = loginService.register(user);
        return BackResult.success(register);
    }


}
