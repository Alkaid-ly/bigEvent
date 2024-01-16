package com.itcast.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:05
 * @Version: 1.0
 * @Description:
 */@Data
public class Category {
    private Integer id;
    private String category_name;
    private String category_alias;
    private String create_user;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
