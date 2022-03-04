package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.vo.CategoryVo;

public interface CategoryService {

    CategoryVo findCategoryById(Long id);
}