package scau.huangyk.homeworkmanagementsystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.SysPermission;
import scau.huangyk.homeworkmanagementsystem.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface SysRoleService extends IService<SysRole> {
    List<SysPermission> getPermissions(Long roleId);
    List<SysRole> getRoleList();
    LayuiDataGridResult getList(Page<SysRole> page, String keyword, Integer status);
}
