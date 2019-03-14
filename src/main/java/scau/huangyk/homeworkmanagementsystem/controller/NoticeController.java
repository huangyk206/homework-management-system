package scau.huangyk.homeworkmanagementsystem.controller;


import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import scau.huangyk.homeworkmanagementsystem.base.BaseController;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.entity.Notice;
import scau.huangyk.homeworkmanagementsystem.service.CourseService;
import scau.huangyk.homeworkmanagementsystem.service.NoticeService;
import scau.huangyk.homeworkmanagementsystem.util.ArrayUtil;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.util.SessionUtil;
import scau.huangyk.homeworkmanagementsystem.vo.NoticeVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value ={"/add.html","/edit.html"})
    public String add(Long teacherId,@RequestParam(required = false)Long noticeId, Model model){
        if(noticeId!=null){
            model.addAttribute("notice",noticeService.selectById(noticeId));
        }
        model.addAttribute("courseList",courseService.getByTeacherId(teacherId));
        return "/teacher/notice/edit";
    }

    @RequestMapping(value = "/teacher/list.html")
    public String list(Model model){
        Long teacherId= SessionUtil.getUserSession(request).getId();
        model.addAttribute("courseList",courseService.getByTeacherId(teacherId));
        return "/teacher/notice/list";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(Notice notice){
        if(notice.getId()==null){
            if(noticeService.insert(notice)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(noticeService.updateById(notice)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
            return new ResultModel(Constants.FAIL,"修改失败");
        }
    }

//    @ResponseBody
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public ResultModel update(Notice notice){
//        if(noticeService.insert(notice)){
//            return new ResultModel(Constants.SUCCESS,"修改成功");
//        }
//        return new ResultModel(Constants.FAIL,"修改失败");
//    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String noticeIds){
        if(noticeService.deleteBatchIds(ArrayUtil.toList(noticeIds))){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }

    @ResponseBody
    @RequestMapping(value = "/student/list")
    public LayuiDataGridResult getListByStuId(@RequestParam("stuId") Long stuId, int limit, int page){
        Page<NoticeVo> p=new Page<>(page,limit);
        return noticeService.getNoticeListByStuId(p,stuId);
    }

    @ResponseBody
    @RequestMapping(value = "/teacher/list")
    public LayuiDataGridResult getListByTeacherId(@RequestParam("teacherId") Long teacherId,@RequestParam(value = "keyword",required = false)String title,
                                                  @RequestParam(value = "courseId",required = false)Long courseId, int limit, int page){
        Page<NoticeVo> p=new Page<>(page,limit);
        return noticeService.getNoticeListByTeacherId(p,teacherId,title,courseId);
    }

    @ResponseBody
    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    public ResultModel publish(Long noticeId,Integer isPublish){
        if(noticeService.publishNotice(noticeId,isPublish)){
            return new ResultModel(Constants.SUCCESS,"修改成功");
        }
        return new ResultModel(Constants.FAIL,"修改失败");
    }



}

