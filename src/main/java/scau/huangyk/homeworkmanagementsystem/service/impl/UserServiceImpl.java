package scau.huangyk.homeworkmanagementsystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.entity.User;
import scau.huangyk.homeworkmanagementsystem.mapper.UserMapper;
import scau.huangyk.homeworkmanagementsystem.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import scau.huangyk.homeworkmanagementsystem.util.PasswordUtil;
import scau.huangyk.homeworkmanagementsystem.vo.UserVo;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    public User checkPassword(String account,String password){
        String pass=PasswordUtil.MD5Encode(password);
        User user=baseMapper.selectByAccountAndPassword(account,pass);
        return user;
    }

    @Override
    public User getByAccount(String account) {
        return baseMapper.selectByAccount(account);
    }

    @Override
    public boolean updateByUserId(User user) {
        return baseMapper.updateByUserId(user)>0;
    }

    @Override
    public boolean updatePasswordById(Long userId, String password) {
        return baseMapper.updatePasswordById(userId,password)>0;
    }

    @Override
    public LayuiDataGridResult getUserList(Page<UserVo> page, String account, Integer status, Long roleId) {
        LayuiDataGridResult result=new LayuiDataGridResult();
        List<UserVo> list=baseMapper.selectUserList(page, account, status, roleId);
        result.setData(list);
        result.setCount(page.getTotal());
        return result;
    }

    @Override
    public UserVo getUser(Long userId) {
        return baseMapper.selectUserById(userId);
    }

}
