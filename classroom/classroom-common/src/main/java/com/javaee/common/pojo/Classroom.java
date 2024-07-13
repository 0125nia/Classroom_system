package com.javaee.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classroom {
    //教室主键id
    private Integer id;
    //教学楼编号
    private Integer buildingId;
    //教室详细名称
    private String name;
    //教室容量
    private Integer capacity;
    //说明
    private String desc;
}
