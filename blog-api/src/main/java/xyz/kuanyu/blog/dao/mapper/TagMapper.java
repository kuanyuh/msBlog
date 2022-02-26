package xyz.kuanyu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.kuanyu.blog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> findTagsByArticleId(Long articleId);

    //查询最热标签 前n个
    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
