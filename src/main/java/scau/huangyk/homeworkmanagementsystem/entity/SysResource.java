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
@TableName("sys_resource")
public class SysResource extends BaseModel<SysResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 父级资源id
     */
	private Long parentId;
    /**
     * 名称
     */
	private String name;
    /**
     * 图标
     */
	private String icon;
    /**
     * 资源路径
     */
	private String url;
    /**
     * 1有效，0删除
     */
	@TableLogic
	private String valid;
    /**
     * 是否打开新窗口：1-打开，2-不打开
     */
	private Integer isBlank;

	/**
	 * 状态
	 */
	private Integer status;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
