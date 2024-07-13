package com.javaee.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nia
 * @description 角色枚举
 * @Date 2024/6/11
 */
@Getter
@AllArgsConstructor
public enum RoleType {


    ADMIN(0,"ADMIN","管理员"),
    STUDENT(1,"STUDENT","学生"),
    TEACHER(2,"TEACHER","教师"),
    ;


    private final Integer code;

    private final String msg;

    private final String desc;

//    private final List<String> permissions;
}
