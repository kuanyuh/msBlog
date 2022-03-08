package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    Result findAll();
}
