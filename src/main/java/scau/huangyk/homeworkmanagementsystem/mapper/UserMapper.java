package scau.huangyk.homeworkmanagementsystem.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import scau.huangyk.homeworkmanagementsystem.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import scau.huangyk.homeworkmanagementsystem.vo.UserVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
public interface UserMapper extends BaseMapper<User> {
   User selectByAccountAndPassword(@Param("account") String account, @Param("password") String password);
   User selectByAccount(String account);
   Integer updateByUserId(User user);
   Integer updatePasswordById(@Param("userId")Long userId,@Param("password")String password);
   List<UserVo> selectUserList(Page<UserVo> page,@Param("account")String account,@Param("status")Integer status,@Param("roleId")Long roleId);
   UserVo selectUserById(Long userId);

}
