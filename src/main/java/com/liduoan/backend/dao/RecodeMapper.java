package com.liduoan.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liduoan.backend.pojo.entity.Recode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liduoan
 * @date 2021年10月06日 1:14
 */
@Mapper
public interface RecodeMapper extends BaseMapper<Recode> {
    List<Recode> findByGuest(Long userId);
}
