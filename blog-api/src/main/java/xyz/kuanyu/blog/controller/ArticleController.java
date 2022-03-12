package xyz.kuanyu.blog.controller;

import org.springframework.web.bind.annotation.*;
import xyz.kuanyu.blog.common.aop.LogAnnotation;
import xyz.kuanyu.blog.common.cache.Cache;
import xyz.kuanyu.blog.service.ArticleService;
import xyz.kuanyu.blog.vo.ArticleVo;
import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.params.ArticleParam;
import xyz.kuanyu.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    @LogAnnotation(module="文章",operation="获取文章列表")
    public Result listArticle(@RequestBody PageParams pageParams){
        //ArticleVo 页面接收的数据


        return articleService.listArticle(pageParams);
    }

    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    @PostMapping("new")
    @Cache(expire = 5 * 60 * 1000,name = "new_article")
    public Result newArticles(){
        int limit = 5;
        return articleService.newArticles(limit);
    }

    @PostMapping("listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}
