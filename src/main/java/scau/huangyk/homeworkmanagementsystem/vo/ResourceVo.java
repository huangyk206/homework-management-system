package scau.huangyk.homeworkmanagementsystem.vo;

import lombok.Data;

@Data
public class ResourceVo {
    private Long id;
    private String resourceName;
    private String courseName;
    private String typeName;
    private String uploadTime;
    private String srcPath;
}
