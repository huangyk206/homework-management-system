package scau.huangyk.homeworkmanagementsystem.vo;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class HomeworkVo {
    private Long id;
    private String courseName;
    private String subject;
    private Timestamp deadline;
    private String typeName;
    private String remark;
    private String require;
    private Timestamp submitTime;
    private String fileType;
    private String submitRemark;
    private String submitFile;
    private String srcPath;
    private Integer fileSize;
}
