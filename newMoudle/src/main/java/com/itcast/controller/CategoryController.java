package com.itcast.controller;

import com.itcast.pojo.Category;
import com.itcast.pojo.Result;
import com.itcast.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/20 12:41
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public Result add(@RequestBody @Validated Category category){
        categoryService.add(category);
        return Result.success();
    }
}
