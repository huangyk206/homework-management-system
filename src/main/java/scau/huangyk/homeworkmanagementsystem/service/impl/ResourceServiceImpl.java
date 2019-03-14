package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Resource;
import scau.huangyk.homeworkmanagementsystem.mapper.ResourceMapper;
import scau.huangyk.homeworkmanagementsystem.service.ResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import scau.huangyk.homeworkmanagementsystem.vo.ResourceVo;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Override
    public LayuiDataGridResult getListByStuId(Page<ResourceVo> page, Long stuId, Long courseId, Long typeId) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<ResourceVo> list=baseMapper.selectListByStuId(page,stuId,courseId,typeId);
        result.setData(list);
        result.setCount(page.getTotal());
        return result;
    }

    @Override
    public LayuiDataGridResult getListByTeacherId(Page<ResourceVo> page, Long teacherId, Long courseId, Long typeId, String resourceName) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<ResourceVo> list=baseMapper.selectListByTeacherId(page,teacherId,courseId,typeId,resourceName);
        result.setData(list);
        result.setCount(page.getTotal());
        return result;
    }

//    @Override
//    public boolean deleteByResourceId(Long resourceId) {
//        return baseMapper.deleteById(resourceId)>0;
//    }
//
//    @Override
//    public boolean updateByResourceId(Resource resource) {
//        return baseMapper.updateById(resource)>0;
//    }

}
