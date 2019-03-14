package scau.huangyk.homeworkmanagementsystem.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import scau.huangyk.homeworkmanagementsystem.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-02-27
 */
@Controller
@RequestMapping("/sysLoginLog")
public class SysLoginLogController extends BaseController {

    @RequestMapping(value = "/list.html")
    public String list(){
        return "/admin/log/login_log_list";
    }

}

