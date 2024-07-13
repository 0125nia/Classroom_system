package com.javaee.web.service.impl;

import com.javaee.common.pojo.Account;
import com.javaee.web.security.LoginUser;
import com.javaee.web.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author nia
 * @description
 * @Date 2024/6/24
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountMapper.selectAccountById(username);
        if (Objects.isNull(account)){
            throw new UsernameNotFoundException("不存在此用户");
        }
        return new LoginUser(account);
    }
}
