package com.javaee.common.utils;

import com.javaee.common.constants.ClassroomConstants;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
public class DateUtils {
    public static String getFormatByDateNow(){
        // 获取特定时区的当前日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ClassroomConstants.ZONEID);
        // 格式化日期并返回
        return getFormatByDate(zonedDateTime.toLocalDate());
    }

    public static String getFormatByDate(LocalDate localDate){
        return localDate.format(ClassroomConstants.FORMATTER);
    }
}
