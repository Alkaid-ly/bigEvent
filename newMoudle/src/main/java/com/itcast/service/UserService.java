package com.itcast.service;

import com.itcast.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/13 22:17
 * @Version: 1.0
 * @Description:
 */

public interface UserService {
    User findByUserName(String username);
    void register(String username,String password);

    void update(User user);
//更新头像
    void updateAvatar(String avatarUrl);
//更新密码
    void updatePwd(String newPwd);
}
