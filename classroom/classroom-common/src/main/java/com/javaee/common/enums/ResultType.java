package com.javaee.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
@AllArgsConstructor
@Getter
@ToString
public enum ResultType {

    SUCCESS(1,"success"),
    FAIL(0,"fail"),

    LOGIN_SUCCESS(2000,"登录成功"),
    LOGIN_FAIL(1000,"登录失败"),
    LOGOUT(2001,"登出成功"),
    LOGOUT_ERROR(1001, "登出失败"),


    ACCOUNT_DISABLED(3000, "用户不可用"),
    SELECT_ACCOUNT_ERROR(3001, "查询用户错误"),

    PERMISSION_DENIED_UPDATE_ADMIN(4000, "无权限修改管理员"),
    PERMISSION_DENIED(4001, "无权限"),

    ;
    private final Integer code;
    private final String msg;
}
