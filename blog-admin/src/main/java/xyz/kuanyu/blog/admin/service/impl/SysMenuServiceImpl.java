package xyz.kuanyu.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.kuanyu.blog.admin.entity.SysMenu;
import xyz.kuanyu.blog.admin.service.SysMenuService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SysMenuServiceImpl implements SysMenuService {
    @Override
    public List<SysMenu> tree() {
        return null;
    }

    @Override
    public boolean saveBatch(Collection<SysMenu> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysMenu> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<SysMenu> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SysMenu entity) {
        return false;
    }

    @Override
    public SysMenu getOne(Wrapper<SysMenu> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<SysMenu> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<SysMenu> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<SysMenu> getBaseMapper() {
        return null;
    }

    @Override
    public Class<SysMenu> getEntityClass() {
        return null;
    }
}
