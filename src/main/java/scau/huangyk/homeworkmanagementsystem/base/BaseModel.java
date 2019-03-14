package scau.huangyk.homeworkmanagementsystem.base;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 基础model
 * @author huangyk
 * @since 2019.01.17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseModel<T extends Model> extends Model<T> implements Serializable {

    @TableId(type = IdType.AUTO)
    protected Long id;
    /**
     * 数据插入时间
     */
    @TableField(value = "createTime", fill = FieldFill.INSERT, strategy = FieldStrategy.NOT_NULL)
    protected Timestamp createTime;
    /**
     * 数据修改时间
     */
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE, strategy = FieldStrategy.NOT_NULL)
    protected Timestamp updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
