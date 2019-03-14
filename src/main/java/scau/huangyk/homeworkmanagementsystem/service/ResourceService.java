package scau.huangyk.homeworkmanagementsystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.Resource;
import com.baomidou.mybatisplus.service.IService;
import scau.huangyk.homeworkmanagementsystem.vo.ResourceVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
public interface ResourceService extends IService<Resource> {

    LayuiDataGridResult getListByStuId(Page<ResourceVo> page, Long stuId, Long courseId, Long typeId);

    LayuiDataGridResult getListByTeacherId(Page<ResourceVo> page, Long stuId, Long courseId, Long typeId,String courseName);

//    boolean deleteByResourceId(Long resourceId);
//
//    boolean updateByResourceId(Resource resource);
}
