package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.dao.pojo.SysUser;
import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.UserVo;

public interface SysUserService {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    Result findUserByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);
}
