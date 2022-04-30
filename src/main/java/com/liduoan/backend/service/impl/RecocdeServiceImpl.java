package com.liduoan.backend.service.impl;

import com.liduoan.backend.dao.RecodeMapper;
import com.liduoan.backend.pojo.entity.Guest;
import com.liduoan.backend.pojo.entity.Recode;
import com.liduoan.backend.service.GuestService;
import com.liduoan.backend.service.RecodeService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author liduoan
 * @date 2021年10月06日 14:07
 */
@Service
@Transactional
public class RecocdeServiceImpl implements RecodeService {

    @Autowired
    RecodeMapper recodeMapper;

    @Autowired
    GuestService guestService;

    @Override
    public List<Recode> findByGuest(Long guestId) {
        return recodeMapper.findByGuest(guestId);
    }

    @Override
    public Integer save(Recode recode) {

        //保证数据的唯一性
        //这个依赖只能唯一 先查
        Long itemPrices = Long.valueOf(recode.getItemPrice());
        Guest guest = guestService.getById(recode.getGuestId());
        Long curPrice = guest.getPrices() - itemPrices;
        //金额判断
        Assert.isTrue(curPrice > 0, "金额不足");
        guest.setPrices(curPrice);
        //更新用户信息
        guestService.updateUser(guest);
        //添加记录信息
//        recode.setUsername(userId);
        save(recode);

        return recodeMapper.insert(recode);
    }
}
