package com.liduoan.backend.service;

import com.liduoan.backend.pojo.entity.Guest;

public interface GuestService {

    /**
     * 保存用户信息
     */
    Integer save(Guest guest);

    /**
     * 通过电话号码获取用户信息
     */
    Guest getByPhone(String phone);

    /**
     * 通过客户姓名获取用户信息
     */
    Guest getByName(String name);

    /**
     * 通过id获取某个用户的信息
     */
    Guest getById(Long id);


    /**
     * 更新用户信息
     */
    Integer updateUser(Guest guest);

    /**
     * 根据手机或姓名查询用户
     */
    Guest getGuestInfo(String info);
}
