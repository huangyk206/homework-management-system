package scau.huangyk.homeworkmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.entity.User;
import scau.huangyk.homeworkmanagementsystem.service.UserService;
import scau.huangyk.homeworkmanagementsystem.util.Constants;
import scau.huangyk.homeworkmanagementsystem.util.SessionUtil;
import scau.huangyk.homeworkmanagementsystem.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  登录控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-02-23
 */
@Controller
public class LoginController{

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value={"/","/login.html"},produces = "text/html;charset=utf-8",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value="/checkLogin",method = RequestMethod.POST)
    public ResultModel checkLogin(String account, String password, String vercode){
        ResultModel result=null;
        String code=StringUtil.toString(request.getSession().getAttribute("vercode"));
        User user=userService.checkPassword(account,password);
        if(StringUtil.isObjectNull(user)){
            result=new ResultModel(Constants.FAIL,"账号或密码错误");
        }else {
            if(vercode.equalsIgnoreCase(code)){
                SessionUtil.setUserSession(request,user);
//                Map<String,Object> data=new HashMap<String,Object>(){{
//                    put("userId",user.getId());
//                    put("userName",user.getUserName());
//                }};
                result=new ResultModel(Constants.SUCCESS,"/front/index");
            }else{
                result=new ResultModel(Constants.FAIL,"验证码错误");
            }
        }
        return result;
    }

    @RequestMapping(value = "/logout.html",method = RequestMethod.GET)
    public String logout(){
        SessionUtil.removeUserSession(request);
        return "redirect:/login.html";
    }

}
