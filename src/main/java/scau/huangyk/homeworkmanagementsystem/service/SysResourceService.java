package scau.huangyk.homeworkmanagementsystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.SysResource;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
public interface SysResourceService extends IService<SysResource> {

    LayuiDataGridResult getList(Page<SysResource> page,String keyword,Integer status);
}
