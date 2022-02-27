package xyz.kuanyu.blog.service;

import xyz.kuanyu.blog.vo.ArticleVo;
import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {

    List<ArticleVo> listArticlesPage(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticles(int limit);

    Result listArchives();
}
