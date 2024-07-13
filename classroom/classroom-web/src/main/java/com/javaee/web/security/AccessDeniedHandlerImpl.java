package com.javaee.web.security;

import com.alibaba.fastjson.JSON;
import com.javaee.common.pojo.Result;
import com.javaee.web.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result<Void> result = Result.resp(HttpStatus.FORBIDDEN.value(),"用户认证失败请查询登录");
        String json = JSON.toJSONString(result);
        WebUtil.renderString(response, json);
    }
}