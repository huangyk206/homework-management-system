package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.SysPermission;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import scau.huangyk.homeworkmanagementsystem.vo.PermissionVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<PermissionVo> selectListByPage(Page<PermissionVo> page, @Param("keyword")String keyword, @Param("status")Integer status);

}
