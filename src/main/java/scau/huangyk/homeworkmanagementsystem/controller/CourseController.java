package scau.huangyk.homeworkmanagementsystem.controller;


import com.baomidou.mybatisplus.plugins.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import scau.huangyk.homeworkmanagementsystem.base.BaseController;
import scau.huangyk.homeworkmanagementsystem.dto.LayuiDataGridResult;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.entity.Course;
import scau.huangyk.homeworkmanagementsystem.entity.User;
import scau.huangyk.homeworkmanagementsystem.service.CourseService;
import scau.huangyk.homeworkmanagementsystem.service.UserService;
import scau.huangyk.homeworkmanagementsystem.util.ArrayUtil;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.vo.StudentVo;

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
@RequestMapping("/course")
@Slf4j
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;

    @RequestMapping(value ={"/add.html","/edit.html"})
    public String add(@RequestParam(required=false)Long courseId, Model model){
        if(courseId!=null){
            model.addAttribute("course",courseService.selectById(courseId));
        }
        return "/teacher/course/edit";
    }

    @RequestMapping(value = "/student/list.html")
    public String studentList(Long courseId,Model model){
        model.addAttribute("courseId",courseId);
        return "/teacher/course/student/list";
    }


    @RequestMapping(value ={"/student/add.html","/student/edit.html"})
    public String addStudent(@RequestParam(required=false)Long stuId, Model model){
        if(stuId!=null){
            User user=userService.selectById(stuId);
            StudentVo student=new StudentVo();
            student.setId(user.getId());
            student.setStuName(user.getUserName());
            student.setStuNum(user.getAccount());
            student.setClazz(user.getClazz());
            model.addAttribute("student",student);
        }
        return "/teacher/course/student/edit";
    }

    @RequestMapping(value = "/teacher/list.html")
    public String list(){
       return "/teacher/course/list";
    }

    @ResponseBody
    @RequestMapping(value = "/student/delete",method = RequestMethod.POST)
    public ResultModel deleteStudent(Long courseId,String stuIds){
        List<Long> stuIdList=ArrayUtil.toList(stuIds);
        if(courseService.deleteStudent(courseId,stuIdList)){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }


    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ResultModel edit(Course course){
        if(course.getId()==null){
            if(courseService.insert(course)){
                return new ResultModel(Constants.SUCCESS,"添加成功");
            }
            return new ResultModel(Constants.FAIL,"添加失败");
        }else{
            if(courseService.updateById(course)){
                return new ResultModel(Constants.SUCCESS,"修改成功");
            }
               return  new ResultModel(Constants.FAIL,"修改失败");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultModel delete(String courseIds){
        if(courseService.deleteBatchIds(ArrayUtil.toList(courseIds))){
            return new ResultModel(Constants.SUCCESS,"删除成功");
        }
        return new ResultModel(Constants.FAIL,"删除失败");
    }



    @ResponseBody
    @RequestMapping(value = "/student/list")
    public LayuiDataGridResult getStudentList(Long courseId,@RequestParam(value = "keyword",required = false)String keyword,
                                              int limit,int page){
        Page<StudentVo> p=new Page<>(page,limit);
        LayuiDataGridResult result=courseService.getStudentListById(p,courseId,keyword);
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/student/edit",method = RequestMethod.POST)
    public ResultModel addStudent(User user,Long courseId){
        ResultModel result=null;
//        if(user.getId()==null){
//            user.setRoleId(Constants.ROLE_STUDENT_KEY);
//
//            if(userService.selectByMap(map)!=null){
//                log.debug("该学生｛｝已存在,将其加入学生-课程关联表",user.getAccount());
//                if(courseService.getCountByStuId(user.getId())>0){
//                    result=new ResultModel(Constants.FAIL,"该课程已包含该学生");
//                }else{
//                    if(courseService.addStudent(courseId,user.getId())){
//                        result=new ResultModel(Constants.SUCCESS,"添加学生成功");
//                    }else{
//                        result=new ResultModel(Constants.FAIL,"添加学生失败");
//                    }
//                }
//            }else{
//                log.debug("该学生｛｝不存在,添加学生帐号,后将其加入学生-课程关联表");
//                if(userService.insert(user)){
//                    if()
//                }
//            }
//        }else{
//
//        }
        return null;
    }



    @ResponseBody
    @RequestMapping(value="/list")
    public LayuiDataGridResult getListByTeacherId(@RequestParam("teacherId")Long teacherId,@RequestParam(required = false) Integer status,
                                               @RequestParam(value = "keyword",required = false) String courseName,int limit, int page){
        Page<Course> p=new Page<>(page,limit);
        LayuiDataGridResult result=courseService.getListByTeacherId(p,teacherId,status,courseName);
        return result;
    }

}

