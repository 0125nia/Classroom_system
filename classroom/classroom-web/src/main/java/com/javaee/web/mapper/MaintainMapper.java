package com.javaee.web.mapper;

import com.javaee.common.pojo.Maintain;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MaintainMapper {

    @Select("SELECT * FROM maintain")
    List<Maintain> selectAll();

    @Insert("insert into maintain(cid, `desc`, type) VALUES (#{cid}, #{desc}, #{type})")
    void insert(Maintain maintain);

    @Update("UPDATE maintain SET cid = #{cid}, `desc` = #{desc}, type = #{type} WHERE id = #{id}")
    void update(Maintain maintain);


    @Delete("DELETE FROM maintain WHERE id = #{id}")
    void deleteById(Integer id);
}
