package com.javaee.web.mapper;

import com.javaee.common.pojo.Classroom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ClassroomMapper {

    @Select("select * from classroom where building_id = #{buildingId}")
    List<Classroom> getClassrooms(Integer buildingId);

    @Insert("insert into classroom(building_id, name) values(#{bid},#{name})")
    void insertClassroom(String bid, String name);

    @Update("update classroom set building_id=#{buildingId}, name = #{name},capacity=#{capacity},`desc`=#{desc} where id=#{id}")
    void updateClassroom(Classroom classroom);
}
