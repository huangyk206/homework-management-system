package scau.huangyk.homeworkmanagementsystem.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public static List<Long> toList(String ids){
        if(StringUtil.isNull(ids)){
            return new ArrayList<>();
        }
        String[] array=ids.split(",");
        List<Long> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            list.add(Long.valueOf(array[i]));
        }
        return list;
    }
}
