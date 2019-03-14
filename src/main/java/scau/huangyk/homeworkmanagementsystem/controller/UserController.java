package scau.huangyk.homeworkmanagementsystem.controller;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import scau.huangyk.homeworkmanagementsystem.base.BaseController;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.entity.SysRole;
import scau.huangyk.homeworkmanagementsystem.entity.User;
import scau.huangyk.homeworkmanagementsystem.service.SysRoleService;
import scau.huangyk.homeworkmanagementsystem.service.UserService;
import scau.huangyk.homeworkmanagementsystem.util.*;
import scau.huangyk.homeworkmanagementsystem.vo.UserVo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public User getInfo(){
        User user=SessionUtil.getUserSession(request);
        return user;
    }

    @RequestMapping(value = {"/add.html","edit.html"})
    public String add(@RequestParam(required = false)Long userId,Model model){
        if(userId!=null){
            model.addAttribute("user",userService.selectById(userId));
        }
        model.addAttribute("roleList",sysRoleService.getRoleList());
        return "/admin/user/edit";
    }

    @RequestMapping(value = "/list.html")
    public String list(Model model){
        model.addAttribute("roleList",sysRoleService.getRoleList());
        return "/admin/user/list";
    }

    @RequestMapping(value = "/info.html")
    public String info(Model model){
        model.addAttribute("user",userService.selectById(SessionUtil.getUserSession(request).getId()));
        return "/common/person_info";
    }

    @RequestMapping(value = "/password.html")
    public String password(){
        return "/common/update_password";
    }

    @ResponseBody
    @RequestMapping(value = "update/pass",method = RequestMethod.POST)
    public ResultModel updatePassword(Long userId, String oldPassword, String newPassword){
        ResultModel result=null;
        User user=userService.selectById(userId);
        if(PasswordUtil.MD5Encode(oldPassword).equals(user.getPassword())){
            if(userService.updatePasswordById(userId,PasswordUtil.MD5Encode(newPassword))){
                result=new ResultModel(Constants.SUCCESS,"修改成功");
            }else{
                result=new ResultModel(Constants.FAIL,"修改失败");
            }
        }else{
            result=new ResultModel(Constants.FAIL,"原密码不正确");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "update/info",method = RequestMethod.POST)
    public ResultModel updateInfo(User user){
        ResultModel result=null;
        if(userService.updateByUserId(user)){
            result= new ResultModel(Constants.SUCCESS,"修改成功");
        }else{
            result=new ResultModel(Constants.FAIL,"修改失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public LayuiDataGridResult list(@RequestParam(value = "keyword",required = false)String account,@RequestParam(required = false)Long roleId,
                                    @RequestParam(required = false)Integer status,int limit,int page){
        Page<UserVo> p=new Page<>(page,limit);
        return userService.getUserList(p,account,status,roleId);
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String userIds){
        if(userService.deleteBatchIds(ArrayUtil.toList(userIds))){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(User user){
        if(user.getId()==null){
            if(userService.getByAccount(user.getAccount())!=null){
                return new ResultModel(Constants.FAIL,"该账号已存在");
            }
            user.setPassword(PasswordUtil.MD5Encode(StringUtil.toString(user.getPassword(),Constants.DEFAULT_PASSWORD)));
            if(userService.insert(user)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(!StringUtil.isEmpty(user.getPassword())){
                user.setPassword(PasswordUtil.MD5Encode(StringUtil.toString(user.getPassword(),Constants.DEFAULT_PASSWORD)));
            }
            if(userService.updateById(user)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
            return new ResultModel(Constants.FAIL,"修改失败");
        }
    }


}
