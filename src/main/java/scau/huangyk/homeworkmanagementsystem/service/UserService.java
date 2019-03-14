package scau.huangyk.homeworkmanagementsystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.User;
import com.baomidou.mybatisplus.service.IService;
import scau.huangyk.homeworkmanagementsystem.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
public interface UserService extends IService<User> {
    User checkPassword(String account, String password);
    User getByAccount(String account);
    boolean updateByUserId(User user);
    boolean updatePasswordById(Long userId,String password);
    LayuiDataGridResult getUserList(Page<UserVo> page,String account,Integer status,Long roleId);
    UserVo getUser(Long userId);
}
