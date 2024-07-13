package com.javaee.web.controller;


import com.javaee.common.pojo.Account;
import com.javaee.common.pojo.Result;
import com.javaee.web.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author nia
 * @description
 * @Date 2024/6/12
 */
@Api(tags = {"用户管理"})
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "登录接口", notes = "用户登录，输入账号密码")
    @PostMapping("/login")
    public Result<String> login(@RequestBody Account account) {
        return accountService.login(account);
    }
    @ApiOperation(value = "登出接口", notes = "用户退出登录")
    @GetMapping("/logout")
    public Result<Void> logout() {
        return accountService.logout();
    }

}
