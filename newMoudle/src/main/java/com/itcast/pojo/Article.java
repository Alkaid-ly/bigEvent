package com.itcast.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:04
 * @Version: 1.0
 * @Description:
 */
@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String cover_img;
    private String state;
    private String category_id;
    private String create_user;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
