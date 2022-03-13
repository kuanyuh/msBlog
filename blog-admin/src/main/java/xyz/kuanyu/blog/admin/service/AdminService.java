package xyz.kuanyu.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.kuanyu.blog.admin.mapper.AdminMapper;
import xyz.kuanyu.blog.admin.mapper.PermissionMapper;
import xyz.kuanyu.blog.admin.pojo.Admin;
import xyz.kuanyu.blog.admin.pojo.Permission;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public Admin findAdminByUserName(String username){
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username).last("limit 1");
        Admin adminUser = adminMapper.selectOne(queryWrapper);
        return adminUser;
    }

    public List<Permission> findPermissionsByAdminId(Long adminId){
        //SELECT * FROM ms_permission WHERE id in (select permission_id from ms_admin_permission where admin_id = 1)
        return permissionMapper.findPermissionsByAdminId(adminId);
    }

}