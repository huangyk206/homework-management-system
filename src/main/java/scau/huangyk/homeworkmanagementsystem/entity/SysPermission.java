package scau.huangyk.homeworkmanagementsystem.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
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
 * @since 2019-02-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_permission")
public class SysPermission extends BaseModel<SysPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
	private String name;
    /**
     * 权限键值
     */
	private String keyCode;
    /**
     * 资源id
     */
	private String resourceId;
    /**
     * 1有效，0删除
     */
	@TableLogic
	private Integer valid;

	/**
	 * 状态
	 */
	private Integer status;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
