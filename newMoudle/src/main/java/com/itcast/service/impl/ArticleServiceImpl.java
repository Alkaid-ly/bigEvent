package com.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itcast.mapper.ArticleMapper;
import com.itcast.pojo.Article;
import com.itcast.pojo.PageBean;
import com.itcast.service.ArticleService;
import com.itcast.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/22 18:12
 * @Version: 1.0
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
//        补充属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
//        创建PageBean对象
        PageBean<Article> pb = new PageBean<>();
//        开启分页查询
        PageHelper.startPage(pageNum,pageSize);
//        调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as= articleMapper.list(userId,categoryId,state);
//        Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<Article> p = (Page<Article>) as;
//        把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
