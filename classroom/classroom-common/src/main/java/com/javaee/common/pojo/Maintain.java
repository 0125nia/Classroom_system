package com.javaee.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maintain {
    private Integer id;
    /**
     * 教室id
     */
    private Integer cid;
    /**
     * 维修说明
     */
    private String desc;
    /**
     * 维修类型 1-电脑设备 2-桌椅 3-电灯
     */
    private Integer type;
}