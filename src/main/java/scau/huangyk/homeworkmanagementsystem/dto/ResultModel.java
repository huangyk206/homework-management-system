package scau.huangyk.homeworkmanagementsystem.dto;

import lombok.Data;

import java.util.Map;

/**
 * 结果模型（json）
 * @author huangyk
 * @since 2019.01.17
 */
@Data
public class ResultModel {
    private int code;
    private String msg;
    private Object data;

    public ResultModel() {
    }

    public ResultModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultModel(int code, String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultModel(int code,Object data) {
        this.code = code;
        this.msg = "";
        this.data = data;
    }

}
