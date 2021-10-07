package com.liduoan.backend.controller;

import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.pojo.entity.Recode;
import com.liduoan.backend.pojo.entity.Guest;
import com.liduoan.backend.service.RecodeService;
import com.liduoan.backend.service.GuestService;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liduoan
 * @date 2021年10月06日 1:12
 */
@RestController
@RequestMapping("/item")
@Slf4j
public class RecodeController {


    @Autowired
    GuestService guestService;

    @Autowired
    RecodeService recodeService;

    @GetMapping("/findByPhone")
    public BackResult<List<Recode>> findByPhone(@RequestParam("phone") String phone) {
        List<Recode> recodes = null;
        //根据电话号码查询用户Id
        Guest guest = guestService.getGuestInfo(phone);
        if (guest == null) {
            return BackResult.fail(recodes);
        }
        Long guestId = guest.getId();
        //查询为该id的所有记录
        recodes = recodeService.findByGuest(guestId);

        return BackResult.success(recodes);
    }

    @PostMapping("/save")
    public BackResult<Recode> save(@RequestBody Recode recode) {
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
        recodeService.save(recode);
        //添加完成记录返回成功
        return BackResult.success(recode);
    }


}
