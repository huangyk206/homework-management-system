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
import scau.huangyk.homeworkmanagementsystem.entity.SysInfo;
import scau.huangyk.homeworkmanagementsystem.entity.SysResource;
import scau.huangyk.homeworkmanagementsystem.service.SysInfoService;
import scau.huangyk.homeworkmanagementsystem.service.SysResourceService;
import scau.huangyk.homeworkmanagementsystem.util.ArrayUtil;
import scau.huangyk.homeworkmanagementsystem.util.Constants;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
@Controller
@RequestMapping("/sysResource")
public class SysResourceController extends BaseController {

    @Autowired
    private SysResourceService sysResourceService;
    @Autowired
    private SysInfoService sysInfoService;

    @RequestMapping(value = "/list.html")
    public String list(){
        return "/admin/resource/list";
    }

    @RequestMapping(value = {"/add.html","edit.html"})
    public String add(@RequestParam(required = false)Long resourceId, Model model){
        if(resourceId!=null){
            model.addAttribute("resource",sysResourceService.selectById(resourceId));
        }
        model.addAttribute("resourceList",sysResourceService.selectList(new EntityWrapper<>()));
        //获取icon列表
        List<SysInfo> list=sysInfoService.getListByKeyCode("icon");
        List<Map<String,String>> iconList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String icon=list.get(i).getDescription();
            String[] arr=icon.split("-");
            Map<String,String> map=new HashMap(){{
                put("id",arr[0]);put("name",arr[1]);
            }};
            iconList.add(map);
        }
        model.addAttribute("iconList",iconList);
        return "/admin/resource/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public LayuiDataGridResult list(@RequestParam(required = false)String keyword,@RequestParam(required = false)Integer status,
                                    int limit, int page){
        Page<SysResource> p=new Page<>(page,limit);
        return sysResourceService.getList(p,keyword,status);
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String resourceIds){
        if(sysResourceService.deleteBatchIds(ArrayUtil.toList(resourceIds))){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(SysResource resource){
        if(resource.getId()==null){
            if(sysResourceService.insert(resource)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(sysResourceService.updateById(resource)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
            return new ResultModel(Constants.FAIL,"修改失败");
        }
    }

//    @ResponseBody
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public ResultModel update(SysResource resource){
//        if(sysResourceService.updateById(resource)){
//            return new ResultModel(Constants.SUCCESS,"修改成功");
//        }
//        return new ResultModel(Constants.FAIL,"修改失败");
//    }


}

