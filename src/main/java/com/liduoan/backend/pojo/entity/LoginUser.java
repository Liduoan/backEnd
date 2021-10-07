package com.liduoan.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liduoan
 * @date 2021年10月02日 18:10
 */
@TableName("admin")
@Data
public class LoginUser extends BaseEntity {

    private String username;

    private String password;

    private Integer existed;
}
