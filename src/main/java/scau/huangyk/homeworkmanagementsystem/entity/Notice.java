package scau.huangyk.homeworkmanagementsystem.entity;

import java.io.Serializable;

import java.sql.Timestamp;

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
public class Notice extends BaseModel<Notice> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
	private Long courseId;
    /**
     * 标题
     */
	private String title;
    /**
     * 正文内容
     */
	private String content;
    /**
     * 是否发布
     */
	private Integer isPublish;
    /**
     * 发布时间
     */
	private Timestamp publishTime;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
