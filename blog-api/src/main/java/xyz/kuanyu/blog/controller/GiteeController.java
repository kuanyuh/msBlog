package xyz.kuanyu.blog.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.kuanyu.blog.utils.GiteeImgBedUtils;
import xyz.kuanyu.blog.vo.Result;

@RestController
@RequestMapping
public class GiteeController {

    @PostMapping("/upload")
    public Result add(@RequestParam("image") MultipartFile multipartFile) {
        String url = GiteeImgBedUtils.upload("image", multipartFile);
        if (StringUtils.isBlank(url)){
            Result.fail(20001,"上传文件失败");
        }
        return Result.success(url);
    }

    @PostMapping("/delete")
    public Result del(String path) {
        return Result.success(GiteeImgBedUtils.delete(path));
    }
}