package com.liduoan.backend.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author liduoan
 * @date 2021年09月28日 23:42
 */
@Component
@Slf4j
public class BackMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert createdTime ing");
        // setFieldValByName方法中参数分别为实体类的属性名、要填充的值，元数据对象
        this.setFieldValByName("createdTime", new Date(), metaObject);
        log.info("insert updatedTime ing");
        this.setFieldValByName("updatedTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("insert updatedTime ing");
        this.setFieldValByName("updatedTime", new Date(), metaObject);
    }
}
