package com.liduoan.backend.controller;

import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.pojo.entity.User;
import com.liduoan.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public BackResult<Integer> save(User user){
        Integer save = userService.save(user);
        return BackResult.success(save);
    }

}
