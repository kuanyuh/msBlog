package xyz.kuanyu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.kuanyu.blog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> findTagsByArticleId(Long articleId);
}
