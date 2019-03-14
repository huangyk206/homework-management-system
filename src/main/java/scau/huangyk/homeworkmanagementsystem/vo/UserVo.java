package scau.huangyk.homeworkmanagementsystem.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author huangyk
 * @since 2019-03-11
 */
@Data
public class UserVo {
    private Long id;
    private String account;
    private String userName;
    private String roleName;
    private String sex;
    private String phone;
    private String email;
    private Timestamp createTime;
}
