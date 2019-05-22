package com.bp.baseProject.util;

import com.bp.baseProject.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class TokenUtil {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    public String getToken() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("token");
        return token;
    }


    public String getUserIdByToken() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("token");
        Map<Object, Object> map = redisTemplate.opsForHash().entries(token);
        if ("user".equals(map.get("roleType"))) {  //前台用户
//			User userInfo = (User) map.get("userInfo");
//			return userInfo.getId();
            return "";
        } else if ("admin".equals(map.get("roleType"))) { //后台用户
            AdminUser adminUserInfo = (AdminUser) map.get("userInfo");
            return adminUserInfo.getId();
        }
        return "";
    }
}
