package scau.huangyk.homeworkmanagementsystem.entity;

import java.io.Serializable;

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
 * @since 2019-03-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseModel<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
	private Long roleId;
    /**
     * 用户名
     */
	private String userName;
    /**
     * 账号
     */
	private String account;
    /**
     * 密码
     */
	private String password;
    /**
     * 班级
     */
	private String clazz;
    /**
     * 手机
     */
	private String phone;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 1有效，0删除
     */
    @TableLogic
	private Integer valid;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 状态
	 */
	private Integer status;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
