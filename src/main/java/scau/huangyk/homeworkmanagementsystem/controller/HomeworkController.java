package scau.huangyk.homeworkmanagementsystem.controller;


import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import scau.huangyk.homeworkmanagementsystem.base.BaseController;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.entity.Homework;
import scau.huangyk.homeworkmanagementsystem.service.CourseService;
import scau.huangyk.homeworkmanagementsystem.service.HomeworkService;
import scau.huangyk.homeworkmanagementsystem.service.SysInfoService;
import scau.huangyk.homeworkmanagementsystem.service.TypeService;
import scau.huangyk.homeworkmanagementsystem.util.ArrayUtil;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.util.SessionUtil;
import scau.huangyk.homeworkmanagementsystem.vo.HomeworkVo;
import scau.huangyk.homeworkmanagementsystem.vo.SubmitHomeworkVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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
@RequestMapping("/homework")
public class HomeworkController extends BaseController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SysInfoService sysInfoService;
    @Autowired
    private TypeService typeService;

    @RequestMapping(value ={"/add.html","/edit.html"})
    public String add(Long teacherId,@RequestParam(required=false)Long homeworkId, Model model){
        if(homeworkId!=null){
            model.addAttribute("homework",homeworkService.selectById(homeworkId));
        }
            model.addAttribute("courseList",courseService.getByTeacherId(teacherId));
            model.addAttribute("fileTypeList", Arrays.asList(sysInfoService.getFileType().split("\\|")));
            model.addAttribute("homeworkTypeList",typeService.getListByKeyCode(Constants.HOMEWORK_CODE));
            model.addAttribute("fileType",sysInfoService.getByKeyCode("fileType"));
            model.addAttribute("maxFileSize",Integer.valueOf(sysInfoService.getByKeyCode("maxFileSize")));
        return "/teacher/homework/edit";
    }

    @RequestMapping(value = "/teacher/list.html")
    public String list(Model model){
        Long teacherId= SessionUtil.getUserSession(request).getId();
        model.addAttribute("courseList",courseService.getByTeacherId(teacherId));
        return "/teacher/homework/list";
    }


    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(Homework homework){
        if(homework.getId()==null){
            if(homeworkService.insert(homework)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(homeworkService.updateById(homework)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
            return new ResultModel(Constants.FAIL,"修改失败");
        }

    }

//    @ResponseBody
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public ResultModel update(Homework homework){
//        if(homeworkService.insert(homework)){
//            return new ResultModel(Constants.SUCCESS,"修改成功");
//        }
//        return new ResultModel(Constants.FAIL,"修改失败");
//    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String homeworkIds){
       if(homeworkService.deleteBatchIds( ArrayUtil.toList(homeworkIds))){
           return new ResultModel(Constants.SUCCESS,"删除成功");
       }
       return new ResultModel(Constants.FAIL,"删除失败");
    }



    @ResponseBody
    @RequestMapping(value = "/student/list")
    public LayuiDataGridResult getListByStuId(@RequestParam("stuId") Long stuId, @RequestParam(required = false) Long courseId,@RequestParam(required = false)Integer status,
            int limit, int page){
        Page<HomeworkVo> p=new Page<>(page,limit);
        return homeworkService.getListByStuId(p,stuId,courseId,status);
    }

    @ResponseBody
    @RequestMapping("/student/submit")
    public ResultModel submitHomework(Long stuId,Long homeworkId,String remark,String srcPath){
        if(homeworkService.submitHomework(stuId,homeworkId,remark,srcPath)){
            return new ResultModel(Constants.SUCCESS,"提交成功");
        }
        return new ResultModel(Constants.FAIL,"提交失败");
    }

    @ResponseBody
    @RequestMapping(value = "/teacher/list")
    public LayuiDataGridResult getListByTeacherId(@RequestParam("teacherId") Long teacherId, @RequestParam(required = false) Long courseId,@RequestParam(required = false)Integer status,
                                              @RequestParam(value = "keyword",required = false)String subject, int limit, int page){
        Page<HomeworkVo> p=new Page<>(page,limit);
        return homeworkService.getListByTeacherId(p,teacherId,courseId,status,subject);
    }

    @RequestMapping(value = "/submit/list.html")
    public String submitList(@RequestParam(required = false)Long homeworkId,Model model){
        if(homeworkId!=null){
            model.addAttribute("homeworkId",homeworkId);
        }
        return "/teacher/homework/submit/list";
    }



    @ResponseBody
    @RequestMapping(value = "/student/submit/list")
    public LayuiDataGridResult getHistoryListByStuId(Long teacherId,@RequestParam(required = false)Long courseId,@RequestParam(required = false)Long homeworkId,
                                                     @RequestParam(required = false)Integer isSubmit,@RequestParam(required = false)Integer isRevise,
                                                     @RequestParam(required = false)String keyword,int limit, int page){
        Page<SubmitHomeworkVo> p=new Page<>(page,limit);
        return homeworkService.getSubmitList(p,teacherId, courseId, homeworkId, isSubmit, isRevise, keyword);
    }

    @RequestMapping(value = "/submit/detail.html")
    public String detail(Long homeworkId,Long stuId,Model model){
        model.addAttribute("homework",homeworkService.getSubmitHomework(homeworkId,stuId));
        return "/teacher/homework/submit/detail";
    }

    @RequestMapping(value = "/submit/revise.html")
    public String revise(Long homeworkId,Long stuId,Model model){
        model.addAttribute("homework",homeworkService.getSubmitHomework(homeworkId,stuId));
        return "/teacher/homework/submit/revise";
    }

    @ResponseBody
    @RequestMapping(value = "/submit/revise",method = RequestMethod.POST)
    public ResultModel revise(SubmitHomeworkVo homework){
        if(homeworkService.reviseHomework(homework)){
            return new ResultModel(Constants.SUCCESS,"批改成功");
        }
        return new ResultModel(Constants.FAIL,"批改失败");
    }
}

