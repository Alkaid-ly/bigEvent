package com.itcast.mapper;

import com.itcast.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:15
 * @Version: 1.0
 * @Description:
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    @Insert("insert into user (username,password,create_time,update_time) " +
            " values (#{username},#{password},now(),now());")
    Integer add(String username, String password);
}
