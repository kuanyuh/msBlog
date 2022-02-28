package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.dao.pojo.SysUser;

public interface SysUserService {

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);
}
