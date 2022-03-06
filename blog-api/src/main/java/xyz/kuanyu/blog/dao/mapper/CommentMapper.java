package xyz.kuanyu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import xyz.kuanyu.blog.dao.pojo.Comment;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {
}
