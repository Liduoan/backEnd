package com.liduoan.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liduoan.backend.dao.GuestMapper;
import com.liduoan.backend.pojo.entity.Guest;
import com.liduoan.backend.service.GuestService;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liduoan
 * @date 2021年09月28日 22:11
 */
@Service
@Transactional
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestMapper userMapper;

    @Override
    public Integer save(Guest guest) {
        return userMapper.insert(guest);
    }

    @Override
    public Guest getByPhone(String phone) {
        return userMapper.selectOne(new LambdaQueryWrapper<Guest>().eq(Guest::getPhone, phone));
    }

    @Override
    public Guest getByName(String name) {
        return userMapper.selectOne(new LambdaQueryWrapper<Guest>().eq(Guest::getName, name));    }

    @Override
    public Guest getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer updateUser(Guest guest) {
        return userMapper.update(guest, new LambdaQueryWrapper<Guest>().eq(Guest::getId, guest.getId()));
    }

    @Override
    public Guest getGuestInfo(String info) {
        Guest guest = null;
        Assert.isTrue(info.length() > 0, "输入无效");
        if (StringUtils.isNumeric(info)) {
            //是电话号码
            guest = getByPhone(info);
        } else {
            guest = getByName(info);
        }
        return guest;
    }


}
