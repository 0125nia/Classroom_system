package com.javaee.web.filter;

import com.alibaba.fastjson.JSON;
import com.javaee.support.constants.SupportConstants;
import com.javaee.support.utils.JWTUtil;
import com.javaee.support.utils.RedisUtil;
import com.javaee.web.security.LoginUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Objects;

/**
 * @author nia
 * @description
 * @Date 2024/6/25
 */
@Slf4j
@Component
public class JWTAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisUtil redisUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String requestURI = request.getRequestURI();
//        if (requestURI.equals(SupportConstants.LOGIN_URI)) {
//            System.out.println(requestURI);
//            filterChain.doFilter(request, response);
//            return;
//        }
//        String token = request.getHeader(SupportConstants.TOKEN);
//        if (!StringUtils.hasText(token)) {
//            throw new RuntimeException("token为空");
//        }
//        String id = JWTUtil.getId(token);
//        String key = RedisUtil.generateLoginKey(id);
//        String jsonStr = redisUtil.get(key);
//        LoginUser loginUser = JSON.parseObject(jsonStr, LoginUser.class);
//
//        if (Objects.isNull(loginUser)) {
//            throw new RuntimeException("用户未登录!");
//        }
//        log.info(loginUser.toString());
//        //存入SecurityContextHolder
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
