package xyz.kuanyu.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.kuanyu.blog.dao.pojo.SysUser;
import xyz.kuanyu.blog.utils.UserThreadLocal;
import xyz.kuanyu.blog.vo.Result;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}