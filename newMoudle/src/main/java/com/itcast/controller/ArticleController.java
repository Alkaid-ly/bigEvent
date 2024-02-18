package com.itcast.controller;

import com.itcast.pojo.Article;
import com.itcast.pojo.PageBean;
import com.itcast.pojo.Result;
import com.itcast.service.ArticleService;
import com.itcast.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/14 22:44
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }
    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum,Integer pageSize,@RequestParam(required = false) Integer categoryId,@RequestParam(required = false) String state){
        PageBean<Article> pb=articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pb);

    }
}
