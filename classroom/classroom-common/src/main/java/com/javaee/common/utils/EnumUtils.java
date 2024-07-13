package com.javaee.common.utils;

import com.javaee.common.enums.RoleType;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
public class EnumUtils {

    private EnumUtils(){}

    /**
     * 根据code获取对应枚举，再返回对应枚举的msg
     * @param code
     * @return
     */
    public static String getRoleTypeMsgByCode(Integer code){
        return Arrays.stream(RoleType.class.getEnumConstants())
                .filter(e -> Objects.equals(e.getCode(), code))
                .findFirst().map(RoleType::getMsg).orElse("");
    }



}
