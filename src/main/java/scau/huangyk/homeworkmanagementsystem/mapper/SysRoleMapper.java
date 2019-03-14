package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.SysPermission;
import scau.huangyk.homeworkmanagementsystem.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysPermission> getPermissions(Long roleId);
    List<SysRole> selectRoleList();
    List<SysRole> selectListByPage(Page<SysRole> page, @Param("keyword")String keyword, @Param("status")Integer status);
}
