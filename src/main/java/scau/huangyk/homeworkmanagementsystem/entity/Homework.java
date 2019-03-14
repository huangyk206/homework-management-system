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
public class Homework extends BaseModel<Homework> {

    private static final long serialVersionUID = 1L;

	private Long courseId;
    /**
     * 类型id
     */
	private Long typeId;
    /**
     * 主题
     */
	private String subject;
    /**
     * 关键字
     */
	private String keyword;
    /**
     * 要求
     */
	private String require;
    /**
     * 备注
     */
	private String remark;
    /**
     * 附件资源
     */
	private String srcPath;
    /**
     * 学生提交附件类型：zip|rar|doc
     */
	private String fileType;
    /**
     * 期限
     */
	private Timestamp deadline;
    /**
     * 1有效，0删除
     */
    @TableLogic
	private Integer valid;

	/**
	 * 附件大小（单位：M）
	 */
	private Integer fileSize;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
