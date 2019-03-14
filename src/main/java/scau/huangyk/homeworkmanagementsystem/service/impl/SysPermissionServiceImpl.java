package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.SysPermission;
import scau.huangyk.homeworkmanagementsystem.mapper.SysPermissionMapper;
import scau.huangyk.homeworkmanagementsystem.service.SysPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import scau.huangyk.homeworkmanagementsystem.vo.PermissionVo;

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
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Override
    public LayuiDataGridResult getList(Page<PermissionVo> page, String keyword, Integer status) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<PermissionVo> list=baseMapper.selectListByPage(page,keyword,status);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }
}
