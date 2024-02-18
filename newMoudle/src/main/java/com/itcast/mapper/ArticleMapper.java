package com.itcast.mapper;

import com.itcast.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/22 18:13
 * @Version: 1.0
 * @Description:
 */
@Mapper
public interface ArticleMapper {
    @Insert("insert into article (title, content, cover_img, state,category_id, create_user, create_time, update_time) " +
            "values (#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime});")
    void add(Article article);

    List<Article> list(Integer userId, Integer categoryId, String state);
}
