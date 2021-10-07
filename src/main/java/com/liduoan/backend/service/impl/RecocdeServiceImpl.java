package com.liduoan.backend.service.impl;

import com.liduoan.backend.dao.RecodeMapper;
import com.liduoan.backend.pojo.entity.Recode;
import com.liduoan.backend.service.RecodeService;
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

    @Override
    public List<Recode> findByGuest(Long guestId) {
        return recodeMapper.findByGuest(guestId);
    }

    @Override
    public Integer save(Recode recode) {
        return recodeMapper.insert(recode);
    }
}
