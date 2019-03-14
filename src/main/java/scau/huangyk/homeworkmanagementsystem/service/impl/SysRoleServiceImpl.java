package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.SysPermission;
import scau.huangyk.homeworkmanagementsystem.entity.SysRole;
import scau.huangyk.homeworkmanagementsystem.mapper.SysRoleMapper;
import scau.huangyk.homeworkmanagementsystem.service.SysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<SysPermission> getPermissions(Long roleId) {
        return baseMapper.getPermissions(roleId);
    }

    @Override
    public List<SysRole> getRoleList() {
        return baseMapper.selectRoleList();
    }

    @Override
    public LayuiDataGridResult getList(Page<SysRole> page, String keyword, Integer status) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<SysRole> list=baseMapper.selectListByPage(page,keyword,status);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }

}
