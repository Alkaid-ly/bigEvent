package com.itcast.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:00
 * @Version: 1.0
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String user_pic;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
