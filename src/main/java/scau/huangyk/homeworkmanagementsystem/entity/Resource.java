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
public class Resource extends BaseModel<Resource> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
	private Long courseId;
    /**
     * 资源名称
     */
	private String name;
	private Integer typeId;
    /**
     * 资源路径
     */
	private String srcPath;
    /**
     * 备注
     */
	private String remark;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
