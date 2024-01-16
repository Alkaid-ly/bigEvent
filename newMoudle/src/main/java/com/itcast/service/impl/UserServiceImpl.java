package com.itcast.service.impl;

import com.itcast.mapper.UserMapper;
import com.itcast.pojo.User;
import com.itcast.service.UserService;
import com.itcast.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:17
 * @Version: 1.0
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u=userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
//        加密
        String md5String = MD5Util.getMD5String(password);
//        添加
        userMapper.add(username,md5String);
    }
}
