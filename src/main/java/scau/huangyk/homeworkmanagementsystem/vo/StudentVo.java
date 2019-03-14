package scau.huangyk.homeworkmanagementsystem.vo;

import lombok.Data;

/**
 *@author huangyk
 *@since 2019-03-09
 */
@Data
public class StudentVo {
    private Long id;
    private String stuNum;
    private String stuName;
    private String clazz;
    private String sex;
}
