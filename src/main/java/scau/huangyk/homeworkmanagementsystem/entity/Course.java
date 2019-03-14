package scau.huangyk.homeworkmanagementsystem.entity;

import java.io.Serializable;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotations.TableLogic;
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
public class Course extends BaseModel<Course> {

    private static final long serialVersionUID = 1L;

    /**
     * 教师id
     */
	private Long teacherId;
    /**
     * 课程名
     */
	private String name;
    /**
     * 备注
     */
	private String remark;
    /**
     * 1有效，0删除
     */

	@TableLogic
	private Integer valid;
    /**
     * 开始时间
     */
	private Timestamp startTime;
    /**
     * 结束时间
     */
	private Timestamp endTime;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
