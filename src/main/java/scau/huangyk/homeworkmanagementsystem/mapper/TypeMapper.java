package scau.huangyk.homeworkmanagementsystem.mapper;

import scau.huangyk.homeworkmanagementsystem.entity.Type;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
public interface TypeMapper extends BaseMapper<Type> {
    public List<Type> selectByKeyCode(String keyCode);
}
