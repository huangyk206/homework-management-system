package scau.huangyk.homeworkmanagementsystem.mapper;

import scau.huangyk.homeworkmanagementsystem.entity.SysInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-03-10
 */
public interface SysInfoMapper extends BaseMapper<SysInfo> {

    String selectFileType();

    String selectByKeyCode(String keyCode);

    List<SysInfo> selectListByKeyCode(String keyCode);
}
