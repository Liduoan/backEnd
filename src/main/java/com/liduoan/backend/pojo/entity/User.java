package com.liduoan.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author liduoan
 * @date 2021年09月28日 22:04
 */
@Data
@TableName("user")
public class User extends BaseEntity{

    private String name;

    /**
     * 用户生日日期
     * */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Long prices;

}
