package scau.huangyk.homeworkmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import scau.huangyk.homeworkmanagementsystem.entity.Course;
import scau.huangyk.homeworkmanagementsystem.entity.SysInfo;
import scau.huangyk.homeworkmanagementsystem.entity.Type;
import scau.huangyk.homeworkmanagementsystem.entity.User;
import scau.huangyk.homeworkmanagementsystem.service.*;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 前端控制器
 * @author huangyk
 * @since 2019-03-03
 */
@Controller
@RequestMapping("front")
public class FrontController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CourseService courseService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private UserService userService;
    @Autowired
    private SysInfoService sysInfoService;


    @RequestMapping(value = "/index",produces = "text/html;charset=utf-8")
    public String index(Model model){
        User user=SessionUtil.getUserSession(request);
        if(user.getRoleId()==Constants.ROLE_STUDENT_KEY){
            model.addAttribute("sysNotice",sysInfoService.getByKeyCode("notice"));
            return "student/index";
        }else if(user.getRoleId()==Constants.ROLE_TEACHER_KEY){
            return "teacher/index";
        }else if(user.getRoleId()==Constants.ROLE_ADMIN_KEY){
            return "admin/index";
        }
      return "login";
    }

    @RequestMapping(value = "/homework/list",produces = "text/html;charset=utf-8")
    public String homework(@RequestParam(name = "userId",required = false) Long stuId,Model model){
        //ModelAndView modelAndView=new ModelAndView();
        //modelAndView.setViewName("student/homework/list");
        List<Course> list=courseService.getByStuId(stuId);
       // modelAndView.addObject("courseList",list);
        model.addAttribute("courseList",list);
        return "student/homework/list";
    }

    @RequestMapping(value = "/course/resourse",produces = "text/html;charset=utf-8")
    public String course(@RequestParam(name = "userId",required = false) Long stuId,Model model){
        //ModelAndView modelAndView=new ModelAndView();
        List<Type> typeList=typeService.getListByKeyCode(Constants.RESOURCE_CODE);
        model.addAttribute("typeList",typeList);
        //modelAndView.addObject("typeList",typeList);
        List<Course> courseList=courseService.getByStuId(stuId);
        model.addAttribute("courseList",courseList);
        //modelAndView.addObject("courseList",courseList);
       // modelAndView.setViewName("student/course/resourse");
        return "student/course/resourse";
    }


    @RequestMapping(value = "/system/about",produces = "text/html;charset=utf-8")
    public String about(Model model){
        List<SysInfo> sysInfoList=sysInfoService.getListByKeyCode("version");
        List<Map<String,Object>> versionList=new ArrayList<>();
        for(int i=0;i<sysInfoList.size();i++){
            Map<String,Object> map=new HashMap<>();
            String[] arr=sysInfoList.get(i).getDescription().split("##");
            map.put("version",arr[0]);
            map.put("desc",arr[1]);
            map.put("date",sysInfoList.get(i).getCreateTime());
            versionList.add(map);
        }
        model.addAttribute("versionList",versionList);
        model.addAttribute("copyright",sysInfoService.getByKeyCode("copyright"));
        return "student/system/about";
    }

    @RequestMapping(value = "/person_info",produces = "text/html;charset=utf-8")
    public String studentInfo(@RequestParam(required = false)Long userId,Model model){
        //ModelAndView modelAndView=new ModelAndView();
        User user=userService.selectById(userId);
        model.addAttribute("user",user);
        //modelAndView.addObject("user",user);
       // modelAndView.setViewName("student/center/person_info");
        return "student/center/person_info";
    }

    @RequestMapping(value = "/update_password",produces = "text/html;charset=utf-8")
    public String studentUpdatePass(){
        return "student/center/update_password";
    }

    @RequestMapping(value = "/history_record",produces = "text/html;charset=utf-8")
    public String history(){
        return "student/center/history_record";
    }

    @RequestMapping(value = "/homework/info",produces = "text/html;charset=utf-8")
    public String homeworkInfo(@RequestParam(required = false) Long homeworkId,Model model){
        //ModelAndView modelAndView=new ModelAndView();
        //modelAndView.addObject("homework",homeworkService.getByHomeworkId(homeworkId));
        //modelAndView.setViewName("student/homework/info");
        model.addAttribute("homework",homeworkService.getByHomeworkId(homeworkId));
        return "student/homework/info";
    }


    @RequestMapping(value = "/homework/submit",produces = "text/html;charset=utf-8")
    public String homeworkSubmit(@RequestParam(required = false) Long homeworkId,Model model){
        //ModelAndView modelAndView=new ModelAndView();
        //modelAndView.addObject("homework",homeworkService.getByHomeworkId(homeworkId));
        //modelAndView.setViewName("student/homework/submit");
        model.addAttribute("homework",homeworkService.getByHomeworkId(homeworkId));
        return "student/homework/submit";
    }

//    @RequestMapping(value = "/teacher/person/person_info",produces = "text/html;charset=utf-8")
//    public String teacherInfo(@RequestParam(value = "userId")String userId,Model model){
//        //ModelAndView modelAndView=new ModelAndView();
//        User user=userService.selectById(userId);
//       // modelAndView.addObject("user",user);
//       // modelAndView.setViewName("/teacher/common/person_info");
//        model.addAttribute("user",user);
//        return "/teacher/common/person_info";
//    }
//
//    @RequestMapping(value = "/teacher/person/update_password",produces = "text/html;charset=utf-8")
//    public String teacherUpdatePass(){
//        return "/teacher/common/update_password";
//    }



}
