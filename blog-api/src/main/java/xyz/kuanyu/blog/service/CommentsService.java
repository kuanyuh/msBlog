package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.params.CommentParam;

public interface CommentsService {
    Result commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}
