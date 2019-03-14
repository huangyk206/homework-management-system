package scau.huangyk.homeworkmanagementsystem.dto;

import lombok.Data;

import java.util.List;

/**
 * 数据表格
 * @author huangyk
 * @since 2019-03-03
 */
public class LayuiDataGridResult {
    private final int DEFAULT=0;
    private int code;
    private String msg;
    private int count;
    private List<?> data;

    public LayuiDataGridResult(){
        this.code=this.DEFAULT;
        this.msg="";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
