package xyz.kuanyu.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.kuanyu.blog.dao.mapper.SysUserMapper;
import xyz.kuanyu.blog.dao.pojo.SysUser;
import xyz.kuanyu.blog.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null){
            sysUser = new SysUser();
            sysUser.setNickname("无昵称");
        }
        return sysUser;
    }
}
