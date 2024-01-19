package com.itcast.interceptors;

import com.itcast.utils.JwtUtil;
import com.itcast.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/17 16:54
 * @Version: 1.0
 * @Description:
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
//            把业务数据存入ThreadLocal中
            ThreadLocalUtil.set(claims);
//            放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);
//            不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
