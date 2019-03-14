package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.SysResource;
import scau.huangyk.homeworkmanagementsystem.mapper.SysResourceMapper;
import scau.huangyk.homeworkmanagementsystem.service.SysResourceService;
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
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

    @Override
    public LayuiDataGridResult getList(Page<SysResource> page, String keyword, Integer status) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<SysResource> list=baseMapper.selectListByPage(page,keyword,status);
        result.setCount(page.getTotal());
        result.setData(list);
        return result;
    }
}
