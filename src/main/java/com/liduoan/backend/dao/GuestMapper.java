package com.liduoan.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liduoan.backend.pojo.entity.Guest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GuestMapper extends BaseMapper<Guest> {
}
