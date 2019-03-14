package scau.huangyk.homeworkmanagementsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import scau.huangyk.homeworkmanagementsystem.base.BaseController;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;
import scau.huangyk.homeworkmanagementsystem.entity.Type;
import scau.huangyk.homeworkmanagementsystem.service.TypeService;
import scau.huangyk.homeworkmanagementsystem.util.Constants;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyk
 * @since 2019-03-03
 */
@Controller
@RequestMapping("/type")
public class TypeController extends BaseController {

    @Autowired
    private TypeService typeService;

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultModel add(Type type){
        if(typeService.insert(type)){
            return new ResultModel(Constants.SUCCESS,"添加成功");
        }
        return new ResultModel(Constants.FAIL,"添加失败");
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultModel update(Type type){
        if(typeService.insert(type)){
            return new ResultModel(Constants.SUCCESS,"修改成功");
        }
        return new ResultModel(Constants.FAIL,"修改失败");
    }

}

