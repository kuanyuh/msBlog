package xyz.kuanyu.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.kuanyu.blog.vo.Result;

@ControllerAdvice //对加了@Controller注解的方法进行拦截处理，AOP 的实现
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.fail(-999, "系统异常");
    }
}
