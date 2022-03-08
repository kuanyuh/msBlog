package xyz.kuanyu.blog.vo.params;

import lombok.Data;
import xyz.kuanyu.blog.vo.CategoryVo;
import xyz.kuanyu.blog.vo.TagVo;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}