package com.itcast.service;

import com.itcast.pojo.Article;
import com.itcast.pojo.PageBean;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/22 18:12
 * @Version: 1.0
 * @Description:
 */
public interface ArticleService {
    void add(Article article);
//    条件列表查询

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
