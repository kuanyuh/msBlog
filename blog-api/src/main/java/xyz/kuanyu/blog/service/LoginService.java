package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.dao.pojo.SysUser;
import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.params.LoginParam;

public interface LoginService {
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    Result logout(String token);
}
