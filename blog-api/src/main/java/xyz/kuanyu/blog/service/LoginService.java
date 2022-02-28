package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.params.LoginParam;

public interface LoginService {
    Result login(LoginParam loginParam);
}
