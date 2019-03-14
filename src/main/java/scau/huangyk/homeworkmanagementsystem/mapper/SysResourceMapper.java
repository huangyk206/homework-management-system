package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.SysResource;
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
public interface SysResourceMapper extends BaseMapper<SysResource> {

    List<SysResource> selectListByPage(Page<SysResource> page, @Param("keyword")String keyword,@Param("status")Integer status);
}
