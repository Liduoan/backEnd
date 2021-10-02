package com.liduoan.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liduoan.backend.pojo.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liduoan
 * @date 2021年10月02日 18:16
 */
@Mapper
public interface LoginDao extends BaseMapper<LoginUser> {

}
