package com.javaee.support.constants;

import java.nio.charset.StandardCharsets;

/**
 * @author nia
 * @description
 * @Date 2024/6/13
 */
public class SupportConstants {


    public static final byte[] SIGN_KEY =  "javaee_classroom_nia_221543229".getBytes(StandardCharsets.UTF_8);
    public static final Long EXPIRE = 64800000L; //7天过期

    public static final String ID = "id";

    public static final String LOGIN_URI = "/account/login";

    public static final String TOKEN = "token";

    public static final String LOGIN = "login:";

}
