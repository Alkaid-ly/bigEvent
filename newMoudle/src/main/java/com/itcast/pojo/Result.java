package com.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:08
 * @Version: 1.0
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    public static <E> Result<E> success(E data){
        return new Result<>(0,"操作成功",data);
    }
    public static Result success(){
        return new Result(0,"操作成功",null);
    }
    public static Result error(String message){
        return new Result(1,message,null);
    }
}
