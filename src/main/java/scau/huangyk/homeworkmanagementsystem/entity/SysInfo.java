package scau.huangyk.homeworkmanagementsystem.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import scau.huangyk.homeworkmanagementsystem.base.BaseModel;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangyk
 * @since 2019-03-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_info")
public class SysInfo extends BaseModel<SysInfo> {

    private static final long serialVersionUID = 1L;

	private String keyCode;
	private String description;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
