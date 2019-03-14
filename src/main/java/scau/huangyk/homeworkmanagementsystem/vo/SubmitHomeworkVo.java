package scau.huangyk.homeworkmanagementsystem.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author huangyk
 * @since 2019-03-11
 */
@Data
public class SubmitHomeworkVo {
    private Long stuId;
    private Long homeworkId;
    private String stuName;
    private String clazz;
    private String stuNum;
    private String subject;
    private String courseName;
    private Timestamp submitTime;
    private Integer isRevise;
    private Integer score;
    private String submitRemark;
    private String srcPath;
    private String feedback;
}
