package com.javaee.web.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * @author nia
 * @description
 * @Date 2024/6/14
 */
public class WebUtil {
    /**
     * 将字符串渲染到客户端
     * @return
     */
    public static String renderString(HttpServletResponse response, String s){
        try{
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(s);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }
}
