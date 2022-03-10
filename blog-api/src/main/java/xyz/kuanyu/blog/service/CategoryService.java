package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.vo.CategoryVo;
import xyz.kuanyu.blog.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long id);

    Result findAll();

    Result findAllDetail();
}