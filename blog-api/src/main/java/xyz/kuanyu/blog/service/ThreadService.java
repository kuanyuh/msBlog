package xyz.kuanyu.blog.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import xyz.kuanyu.blog.dao.mapper.ArticleMapper;
import xyz.kuanyu.blog.dao.pojo.Article;

@Component
public class ThreadService {

    //期望此操作在线程池执行不会影响原有主线程
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {
        int viewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCounts + 1);
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId, article.getId());
        //设置一个 为了在多线程环境下 线程安全
        //改之前再确认这个值有没有被其他线程抢先修改，类似于CAS操作 cas加自旋，加个循环就是cas

        updateWrapper.eq(Article::getViewCounts, viewCounts);
        //update article set view_count=100 where view_count=? and id =?
        //这里update多设置了字段，应该是article表用的int有默认值，导致这两字段被覆盖了
        articleMapper.update(articleUpdate,updateWrapper);
    }
}
