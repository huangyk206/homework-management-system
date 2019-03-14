package scau.huangyk.homeworkmanagementsystem.dto;

import lombok.Data;

import java.util.List;

/**
 * @author huangyk
 * @since 2019-03-12
 */
@Data
public class ExcelData {
    //表头
    private List<String> titles;
    //数据
    private List<List<String>> rows;
    //页签名称
    private String name;
}
