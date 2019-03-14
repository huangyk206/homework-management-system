package scau.huangyk.homeworkmanagementsystem.controller;


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
import scau.huangyk.homeworkmanagementsystem.entity.Resource;
import scau.huangyk.homeworkmanagementsystem.service.CourseService;
import scau.huangyk.homeworkmanagementsystem.service.ResourceService;
import scau.huangyk.homeworkmanagementsystem.service.TypeService;
import scau.huangyk.homeworkmanagementsystem.util.ArrayUtil;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.util.SessionUtil;
import scau.huangyk.homeworkmanagementsystem.vo.ResourceVo;

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
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TypeService typeService;

    @RequestMapping(value ={"/add.html","/edit.html"})
    public String add(Long teacherId,@RequestParam(required = false)Long resourceId, Model model){
        if(resourceId!=null){
            model.addAttribute("resource",resourceService.selectById(resourceId));
        }
        model.addAttribute("courseList",courseService.getByTeacherId(teacherId));
        model.addAttribute("resourceTypeList",typeService.getListByKeyCode(Constants.RESOURCE_CODE));
        return "/teacher/resource/edit";
    }

    @RequestMapping(value = "/teacher/list.html")
    public String list(Model model){
        Long teacherId= SessionUtil.getUserSession(request).getId();
        model.addAttribute("courseList",courseService.getByTeacherId(teacherId));
        model.addAttribute("resourceTypeList",typeService.getListByKeyCode(Constants.RESOURCE_CODE));
        return "/teacher/resource/list";
    }

    @ResponseBody
    @RequestMapping(value = "/student/list")
    public LayuiDataGridResult getListByStuId(@RequestParam("stuId")Long stuId, @RequestParam(required = false) Long courseId, @RequestParam(required = false) Long typeId,
        int limit,int page){
        Page<ResourceVo> p=new Page<>(page,limit);
        return resourceService.getListByStuId(p,stuId,courseId,typeId);
    }

    @ResponseBody
    @RequestMapping(value = "/teacher/list")
    public LayuiDataGridResult getListByTeacherId(@RequestParam("teacherId")Long teacherId, @RequestParam(required = false) Long courseId, @RequestParam(required = false) Long typeId,
                                                  @RequestParam(value = "keyword",required = false) String resourceName,int limit,int page){
        Page<ResourceVo> p=new Page<>(page,limit);
        return resourceService.getListByTeacherId(p,teacherId,courseId,typeId,resourceName);
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(Resource resource){
        if(resource.getId()==null){
            if(resourceService.insert(resource)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(resourceService.updateById(resource)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
            return new ResultModel(Constants.FAIL,"修改失败");
        }
    }

//    @ResponseBody
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public ResultModel update(Resource resource){
//        if(resourceService.updateById(resource)){
//            return new ResultModel(Constants.SUCCESS,"修改成功");
//        }
//        return new ResultModel(Constants.FAIL,"修改失败");
//    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String resourceIds){
        if(resourceService.deleteBatchIds(ArrayUtil.toList(resourceIds))){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }

}

