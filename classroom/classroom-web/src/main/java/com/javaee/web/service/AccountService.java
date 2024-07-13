package com.javaee.web.service;

import com.javaee.common.pojo.Account;
import com.javaee.common.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
public interface AccountService {
    Result<String> login(Account account);
    Result<Void> logout();

    Result<Void> batchInsert(MultipartFile file);

    Result<Void> logicallyDelete(String id);

    Result<List<Account>> batchSelect(Integer code);

    Result<Void> batchDelete(List<String> ids);

    Result<Void> insert(Account account);
}
