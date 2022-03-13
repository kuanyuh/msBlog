package xyz.kuanyu.blog.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.kuanyu.blog.admin.pojo.Permission;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("SELECT * FROM ms_permission WHERE id IN (select permission_id from ms_admin_permission where admin_id = #{adminId})")
    List<Permission> findPermissionsByAdminId(Long adminId);
}