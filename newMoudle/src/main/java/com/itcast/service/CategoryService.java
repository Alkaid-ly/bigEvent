package com.itcast.service;

import com.itcast.pojo.Category;

import java.util.List;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/20 12:42
 * @Version: 1.0
 * @Description:
 */
public interface CategoryService {
//    新增分类
    void add(Category category);
//列表查询
    List<Category> list();

    Category findById(Integer id);

    void update(Category category);

    void delete(Integer id);
}
