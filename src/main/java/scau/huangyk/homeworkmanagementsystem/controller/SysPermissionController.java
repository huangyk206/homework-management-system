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
import scau.huangyk.homeworkmanagementsystem.entity.SysPermission;
import scau.huangyk.homeworkmanagementsystem.service.SysPermissionService;
import scau.huangyk.homeworkmanagementsystem.service.SysResourceService;
import scau.huangyk.homeworkmanagementsystem.util.ArrayUtil;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.vo.PermissionVo;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController extends BaseController {

    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysResourceService sysResourceService;


    @RequestMapping(value = {"/add.html","edit.html"})
    public String add(@RequestParam(required = false)Long permissionId,Model model){
        if(permissionId!=null){
            model.addAttribute("permission",sysPermissionService.selectById(permissionId));
        }
        model.addAttribute("resourceList",sysResourceService.selectList(new EntityWrapper<>()));
        return "/admin/permission/edit";
    }


    @RequestMapping(value = "/list.html")
    public String list(){
        return "/admin/permission/list";
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public LayuiDataGridResult list(@RequestParam(required = false)String keyword, @RequestParam(required = false)Integer status,
                                    int limit, int page){
        Page<PermissionVo> p=new Page<>(page,limit);
        return sysPermissionService.getList(p,keyword,status);
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String permissionIds){
        if(sysPermissionService.deleteBatchIds(ArrayUtil.toList(permissionIds))){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(SysPermission permission){
        if(permission.getId()==null){
            if(sysPermissionService.insert(permission)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(sysPermissionService.updateById(permission)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
            return new ResultModel(Constants.FAIL,"修改失败");
        }
    }

}

