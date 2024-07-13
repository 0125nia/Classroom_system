package com.javaee.common.pojo;

import lombok.*;

/**
 * @author nia
 * @description Account
 * @Date 2024/6/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    //学号&学工号 唯一id
    private String id;
    //密码
    private String password;
    //身份标识
    private Integer code;
    //启用标识
    private Boolean enable;
    //身份证号码
    private String cardNumber;

    public Account(String id,String password){
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", password='" + null + '\'' +
                ", code=" + code +
                ", enable=" + enable +
                '}';
    }
}
