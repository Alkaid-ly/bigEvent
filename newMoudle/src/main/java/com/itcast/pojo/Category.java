package com.itcast.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:05
 * @Version: 1.0
 * @Description:
 */@Data
public class Category {
    private Integer id;
    @NotNull
    private String categoryName;
    @NotNull
    private String categoryAlias;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
