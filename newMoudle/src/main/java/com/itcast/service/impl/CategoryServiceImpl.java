package com.itcast.service.impl;

import com.itcast.mapper.CategoryMapper;
import com.itcast.pojo.Category;
import com.itcast.service.CategoryService;
import com.itcast.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/20 12:42
 * @Version: 1.0
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
//        补充属性值
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime((LocalDateTime.now()));
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setCreateUser(userId);
        categoryMapper.add(category);
    }
}
