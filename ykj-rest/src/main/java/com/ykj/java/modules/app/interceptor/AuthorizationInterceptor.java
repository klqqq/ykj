package com.ykj.java.modules.app.interceptor;


import io.jsonwebtoken.Claims;
import com.ykj.java.common.exception.Exception;
import com.ykj.java.modules.app.utils.JwtUtils;
import com.ykj.java.modules.app.annotation.Login;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 * @author bnz
 * @email object_bnz@163.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AppMemberDao appMemberDao;
    public static final String USER_KEY = "username";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws java.lang.Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());
        if(StringUtils.isBlank(token)){
            token = request.getParameter(jwtUtils.getHeader());
        }

        //凭证为空
        if(StringUtils.isBlank(token)){
            throw new Exception(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
        }

        Claims claims = jwtUtils.getClaimByToken(token);
        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
            throw new Exception(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }
        String username = claims.getSubject();
        if (claims == null) {
            throw new Exception("验证错误", HttpStatus.UNAUTHORIZED.value());
        }
        String id = appMemberDao.queryIdByUserName(username);
        if (id == null) {
            throw new Exception("验证错误", HttpStatus.UNAUTHORIZED.value());
        } else {
            return true;
        }
        //设置userId到request里，后续根据userId，获取用户信息
//        request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));

//        return true;
    }
}
