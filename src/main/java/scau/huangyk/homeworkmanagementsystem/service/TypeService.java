package scau.huangyk.homeworkmanagementsystem.service;

import scau.huangyk.homeworkmanagementsystem.entity.Type;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
public interface TypeService extends IService<Type> {

    List<Type> getListByKeyCode(String keyCode);
}
