package scau.huangyk.homeworkmanagementsystem.service;

import scau.huangyk.homeworkmanagementsystem.entity.SysInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-03-10
 */
public interface SysInfoService extends IService<SysInfo> {

    String getFileType();

    String getByKeyCode(String keyCode);

    List<SysInfo> getListByKeyCode(String keyCode);
}
