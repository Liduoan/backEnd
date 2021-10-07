package com.liduoan.backend.service;

import com.liduoan.backend.pojo.entity.Recode;

import java.util.List;

/**
 * @author liduoan
 * @date 2021年10月06日 14:07
 */
public interface RecodeService {

    /**
     * 通过userId获取所有消费记录
     */
    List<Recode> findByGuest(Long guestId);

    /**
     * 添加消费记录
     */
    Integer save(Recode recode);

}
