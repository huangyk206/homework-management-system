package scau.huangyk.homeworkmanagementsystem.entity;

import java.io.Serializable;

import scau.huangyk.homeworkmanagementsystem.base.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Type extends BaseModel<Type> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
	private String name;
    /**
     * 1有效，0删除
     */
	private Integer status;
	private String keyCode;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
