package scau.huangyk.homeworkmanagementsystem.component;


import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author huangyk
 * @since 2019-03-07
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime",new Timestamp(System.currentTimeMillis()));
        metaObject.setValue("updateTime",new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime",new Timestamp(System.currentTimeMillis()));
    }
}
