package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.Resource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import scau.huangyk.homeworkmanagementsystem.vo.ResourceVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    List<ResourceVo> selectListByStuId(Page<ResourceVo> page, @Param("stuId") Long stuId, @Param("courseId") Long courseId, @Param("typeId")Long typeId);

    List<ResourceVo> selectListByTeacherId(Page<ResourceVo> page, @Param("teacherId") Long teacherId, @Param("courseId") Long courseId, @Param("typeId")Long typeId,@Param("resourceName")String resourceName);

//    Integer updateByResourceId(Resource resource);
//
//    Integer deleteByResourceId(Long resourceId);
}
