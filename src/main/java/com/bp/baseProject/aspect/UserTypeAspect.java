package com.bp.baseProject.aspect;

import com.bp.baseProject.annotation.UserTypeAnnotation;
import com.bp.baseProject.entity.vo.ResultVO;
import com.bp.baseProject.util.RedisUtil;
import com.bp.baseProject.util.TokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class UserTypeAspect {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${admin.token.timeout}")
    private String adminTokenTimeout;

    @Value("${user.token.timeout}")
    private String userTokenTimeout;


    @Around("@annotation(userType)")
    public Object checkUserType(ProceedingJoinPoint joinPoint, UserTypeAnnotation userType) throws Throwable {
        String token = new TokenUtil().getToken();
        if (token == null || "".equals(token)) {
            return new ResultVO<String>("005", "请重新登录");
        }
        Map<Object, Object> map = redisUtil.hmget(token);
        if (map.get("userInfo") == null) {
            return new ResultVO<String>("005", "请重新登录");
        }
        String userTypeValue = userType.value();
        if (userTypeValue.equals("user")) {
            if (!"user".equals(map.get("roleType"))) {
                return new ResultVO<String>("005", "请重新登录");
            } else {
                redisUtil.expire(token, Integer.valueOf(userTokenTimeout), TimeUnit.MINUTES);
            }
        } else if (userTypeValue.equals("admin")) {
            if (!"admin".equals(map.get("roleType"))) {
                return new ResultVO<String>("005", "请重新登录");
            } else {
                redisUtil.expire(token, Integer.valueOf(adminTokenTimeout), TimeUnit.MINUTES);
            }
        } else if (userTypeValue.equals("all")) {
            if (!"admin".equals(map.get("roleType")) && !"user".equals(map.get("roleType"))) {
                return new ResultVO<String>("005", "请重新登录");
            } else {
                redisUtil.expire(token, Integer.valueOf(userTokenTimeout), TimeUnit.DAYS);
            }
        }
        Object result = null;
        result = joinPoint.proceed();
        return result;
    }

}
