package com.itcast.mapper;

import com.itcast.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Select(" select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);
    @Select(" select * from category where id = #{id}")
    Category findById(Integer id);
    @Update(" update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void update(Category category);
    @Delete(" delete from category where id=#{id}")
    void delete(Integer id);
}
