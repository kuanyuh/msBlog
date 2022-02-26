package xyz.kuanyu.blog.controller;

import xyz.kuanyu.blog.service.ArticleService;
import xyz.kuanyu.blog.vo.ArticleVo;
import xyz.kuanyu.blog.vo.Result;
import xyz.kuanyu.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        //ArticleVo 页面接收的数据
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);

        return Result.success(articles);
    }
}
