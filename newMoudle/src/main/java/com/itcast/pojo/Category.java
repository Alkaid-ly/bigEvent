package com.itcast.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.time.LocalDateTime;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:05
 * @Version: 1.0
 * @Description:
 */@Data
public class Category {
    @NotNull(groups = Update.class)
    private Integer id;
    @NotNull
    private String categoryName;
    @NotNull
    private String categoryAlias;
    private Integer createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public interface Add extends Default {

    }
    public interface Update extends Default{

    }
}
