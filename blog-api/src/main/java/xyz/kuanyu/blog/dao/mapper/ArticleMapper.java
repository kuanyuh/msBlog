package xyz.kuanyu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import xyz.kuanyu.blog.dao.dos.Archives;
import xyz.kuanyu.blog.dao.pojo.Article;

import java.util.List;

@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();
}
