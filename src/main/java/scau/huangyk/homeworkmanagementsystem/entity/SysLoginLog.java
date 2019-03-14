package scau.huangyk.homeworkmanagementsystem.entity;

import java.io.Serializable;

import java.sql.Timestamp;

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
@TableName("sys_login_log")
public class SysLoginLog extends BaseModel<SysLoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
	private String account;
    /**
     * 用户名
     */
	private String userName;
    /**
     * 登录时间
     */
	private Timestamp loginTime;
    /**
     * 登录ip
     */
	private String ip;
    /**
     * 登录状态（1成功，0失败）
     */
	private Integer status;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
