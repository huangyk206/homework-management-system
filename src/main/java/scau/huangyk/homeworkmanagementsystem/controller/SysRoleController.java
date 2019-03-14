package scau.huangyk.homeworkmanagementsystem.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import scau.huangyk.homeworkmanagementsystem.base.BaseController;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.entity.SysRole;
import scau.huangyk.homeworkmanagementsystem.service.SysRoleService;
import scau.huangyk.homeworkmanagementsystem.util.ArrayUtil;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.util.StringUtil;

import javax.management.relation.Role;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;


    @RequestMapping(value = {"/add.html","edit.html"})
    public String add(@RequestParam(required = false)Long roleId,Model model){
        if(roleId!=null){
            model.addAttribute("role",sysRoleService.selectById(roleId));
        }
        return "/admin/role/edit";
    }


    @RequestMapping(value = "/list.html")
    public String list(){
        return "/admin/role/list";
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String roleIds){
        if(sysRoleService.deleteBatchIds(ArrayUtil.toList(roleIds))){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(SysRole role){
        if(role.getId()==null){
            if(sysRoleService.insert(role)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(sysRoleService.updateById(role)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
            return new ResultModel(Constants.FAIL,"修改失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public LayuiDataGridResult list(@RequestParam(required = false)String keyword, @RequestParam(required = false)Integer status,
                                    int limit, int page){
        Page<SysRole> p=new Page<>(page,limit);
        return sysRoleService.getList(p,keyword,status);
    }

//    @ResponseBody
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public ResultModel update(SysRole role){
//        if(sysRoleService.updateById(role)){
//            return new ResultModel(Constants.SUCCESS,"修改成功");
//        }
//        return new ResultModel(Constants.FAIL,"修改失败");
//    }
}

