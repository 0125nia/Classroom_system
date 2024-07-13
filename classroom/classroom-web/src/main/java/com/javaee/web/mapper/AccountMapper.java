package com.javaee.web.mapper;

import com.javaee.common.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author nia
 * @description
 * @Date 2024/6/10
 */
@Mapper
public interface AccountMapper {
    @Select("select * from account where id = #{id}")
    Account selectAccountById(String id);
    @Insert("insert into account(id, password, code, enable,card_number) VALUE (#{id},#{password},#{code},#{enable},#{cardNumber})")
    void insertAccount(Account account);
    void updateAccount(Account account);
    void batchInsert(List<Account> accountList);
    void batchDelete(@Param("ids") List<String> ids);
    @Select("select * from account where code = #{code} and enable = true")
    List<Account> batchSelectByCode(Integer code);
}
