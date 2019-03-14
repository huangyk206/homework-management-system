package scau.huangyk.homeworkmanagementsystem.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import scau.huangyk.homeworkmanagementsystem.dto.ResultModel;

/**
 * 异常通知
 * @author huangyk
 * @since2019.01.17
 */
@RestControllerAdvice
public class MyControllerAdvice {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResultModel errorHandler(RuntimeException ex){
        return new ResultModel(0,ex.getMessage());
    }

}
