package com.liduoan.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liduoan
 * @date 2021年10月06日 1:12
 */
@Data
@TableName("recodes")
public class Recode extends BaseEntity {
    private Long guestId;

    private String username ;

    private String itemName;

    private String itemPrice;

}
