package com.itcast.mapper;

import com.itcast.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/20 12:43
 * @Version: 1.0
 * @Description:
 */
@Mapper
public interface CategoryMapper {
//    新增分类
    @Insert("insert into category (category_name, category_alias, create_user, create_time, update_time) " +
            "values (#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);
}
