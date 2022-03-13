package xyz.kuanyu.blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.kuanyu.blog.utils.GiteeImgBedUtils;

@RestController
@RequestMapping
public class GiteeController {

    @PostMapping("/add")
    public String add(@RequestParam("file") MultipartFile multipartFile) {
        return GiteeImgBedUtils.upload("picture", multipartFile);
    }

    @PostMapping("/del")
    public String del(String path) {
        return "" + GiteeImgBedUtils.delete(path);
    }
}