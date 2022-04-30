package com.liduoan.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "用户对象", description = "用户表")
public class Guest extends BaseEntity {


    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    /**
     * 用户生日日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "生日日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ApiModelProperty(value = "用户剩余金额")
    private Long prices;

}
