package com.javaee.web;

import com.alibaba.fastjson.JSON;
import com.javaee.common.pojo.Account;
import com.javaee.support.utils.JWTUtil;
import com.javaee.web.security.LoginUser;
import org.junit.jupiter.api.Test;

/**
 * @author nia
 * @description
 * @Date 2024/6/25
 */
public class Test1 {
    @Test
    void name() {
        LoginUser loginUser = new LoginUser(new Account("221543229","123456"));
        String jsonString = JSON.toJSONString(loginUser);
        System.out.println(jsonString);
        String s = JWTUtil.generateJsonJwt("221543229");
        System.out.println(s);
    }
}
