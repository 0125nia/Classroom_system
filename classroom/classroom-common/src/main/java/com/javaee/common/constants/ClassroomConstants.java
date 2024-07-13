package com.javaee.common.constants;

import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
public class ClassroomConstants {


    public static final ZoneId ZONEID = ZoneId.of("Asia/Shanghai");
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd");



}
