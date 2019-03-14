package scau.huangyk.homeworkmanagementsystem.vo;

import lombok.Data;

import java.sql.Timestamp;


/**
 * @author huangyk
 * @since 2019-03-03
 */
@Data
public class NoticeVo {
    private Long id;
    private String courseName;
    private String title;
    private String content;
    private Integer isPublish;
    private Timestamp publishTime;
}
