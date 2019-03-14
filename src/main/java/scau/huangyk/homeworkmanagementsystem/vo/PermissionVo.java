package scau.huangyk.homeworkmanagementsystem.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author huangyk
 * @since 2019-03-12
 */
@Data
public class PermissionVo {
    private Long id;
    private String permissionName;
    private String keyCode;
    private String resourceName;
    private Timestamp createTime;
    private Integer status;
}
