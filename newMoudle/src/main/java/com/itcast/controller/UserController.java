package com.itcast.controller;

import com.itcast.pojo.Result;
import com.itcast.pojo.User;
import com.itcast.service.UserService;
import com.itcast.utils.JwtUtil;
import com.itcast.utils.MD5Util;
import com.itcast.utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

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
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name="Authorization") String token*/){
        /*Map<String, Object> claims = JwtUtil.parseToken(token);
        String username = (String) claims.get("username");*/
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
//        1.校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if(!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要参数");
        }
//        原密码是否正确
//        调用service根据用户名拿到密码，在和oldPwd比对
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (!loginUser.getPassword().equals(MD5Util.getMD5String(oldPwd))) {
            return Result.error("原密码不正确");
        }
//        newPwd和rePwd是否一致
        if(!rePwd.equals(newPwd)){
            return Result.error("两次密码不一致");
        }
//        2.调用service完成密码更新
        userService.updatePwd(newPwd);
        return Result.success();
    }
}
