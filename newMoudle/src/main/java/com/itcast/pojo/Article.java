package com.itcast.pojo;

import com.itcast.annotation.State;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    @URL
    private String coverImg;
    @State
    private String state;
    @NotNull
    private Integer categoryId;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
