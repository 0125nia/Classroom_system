package com.javaee.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nia
 * @description
 * @Date 2024/6/25
 */
@Mapper
public interface BuildingMapper {
    @Select("select name from buildings")
    List<String> select();
}
