package com.liduoan.backend.controller;

import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.pojo.entity.Guest;
import com.liduoan.backend.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class GuestController {


    @Autowired
    private GuestService guestService;

    @PostMapping("/save")
    public BackResult<Integer> save(@RequestBody Guest guest) {
        Integer save = guestService.save(guest);
        return BackResult.success(save);
    }

    @GetMapping("/getGuestInfo")
    public BackResult<Guest> getGuestInfo(@RequestParam("info") String info) {
        Guest guest = guestService.getGuestInfo(info);
        return BackResult.success(guest);
    }



}
