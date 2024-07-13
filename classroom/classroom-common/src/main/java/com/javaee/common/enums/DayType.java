package com.javaee.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nia
 * @description 日期类型
 * @Date 2024/6/12
 */
@Getter
@AllArgsConstructor
public enum DayType {
    WORKDAY("工作日"),
    WEEKEND("周末"),
    HOLIDAY("节假日"),
    EXTRA_WORKDAY("调休补班"),

    ;

    private final String desc;
}
