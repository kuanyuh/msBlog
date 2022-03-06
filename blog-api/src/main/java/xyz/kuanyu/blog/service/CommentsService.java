package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.vo.Result;

public interface CommentsService {
    Result commentsByArticleId(Long articleId);
}
