package com.itcast.controller;

import com.itcast.pojo.Result;
import com.itcast.pojo.User;
import com.itcast.service.UserService;
import com.itcast.utils.JwtUtil;
import com.itcast.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.HashMap;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:15
 * @Version: 1.0
 * @Description:
 */
@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@Pattern(regexp= "^\\S{5,16}$")String username, String password){
//        查询用户
        User u = userService.findByUserName(username);
//        注册
        if(u==null){
            userService.register(username, password);
            return Result.success("注册成功");
        }else{
            return Result.error("用户名已被使用");
        }
    }
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp= "^\\S{5,16}$")String username, String password){
        User user = userService.findByUserName(username);
        if(user==null){
            return Result.error("用户名不存在");
        } else if (MD5Util.getMD5String(password).equals(user.getPassword())) {
            HashMap<String, Object> clamis = new HashMap<>();
            clamis.put("id",user.getId());
            clamis.put("username",user.getUsername());
            String token = JwtUtil.genToken(clamis);
            return Result.success(token);
        }else{
            return Result.error("密码错误");
        }
    }
}
