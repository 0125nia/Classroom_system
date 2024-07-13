package com.javaee.web.service.impl;

import cn.hutool.core.text.csv.*;
import com.alibaba.fastjson.JSON;
import com.javaee.common.enums.ResultType;
import com.javaee.common.enums.RoleType;
import com.javaee.common.pojo.Account;
import com.javaee.common.pojo.Result;
import com.javaee.support.utils.JWTUtil;
import com.javaee.support.utils.RedisUtil;
import com.javaee.web.mapper.AccountMapper;
import com.javaee.web.security.LoginUser;
import com.javaee.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author nia
 * @description
 * @Date 2024/6/25
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Result<String> login(Account account) {

        //封装Authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account.getId(),account.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authentication)){
            throw new RuntimeException("登录失败");
        }

        LoginUser principal = (LoginUser) authentication.getPrincipal();

        String jsonString = JSON.toJSONString(principal);

        String jwt = JWTUtil.generateJsonJwt(account.getId());
        String key = RedisUtil.generateLoginKey(account.getId());
        redisUtil.set(key,jsonString);


        return Result.resp(ResultType.SUCCESS,"登录成功",jwt);
    }
    @Override
    public Result<Void> logout() {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getAccount().getId();
        //删除redis中的用户信息
        String key = RedisUtil.generateLoginKey(userId);
        redisUtil.del(key);
        return Result.resp(ResultType.LOGOUT, "退出成功");
    }

    @Override
    public Result<Void> batchInsert(MultipartFile file) {
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            // 创建CSV读取器
            CsvReader csvReader = CsvUtil.getReader(reader,CsvReadConfig.defaultConfig() );

            // 读取CSV内容
            CsvData rows = csvReader.read();
            List<Account> accounts = csv2Accounts(rows);
//            accounts.forEach(System.out::println);
            accountMapper.batchInsert(accounts);

        } catch (Exception e) {
            // 处理异常
            return Result.resp(ResultType.FAIL,"读取失败");
        }
        return Result.resp(ResultType.SUCCESS,"导入成功");
    }

    @Override
    public Result<Void> logicallyDelete(String id) {
        Account account = accountMapper.selectAccountById(id);
        if (Objects.isNull(account)){
            return Result.resp(ResultType.SELECT_ACCOUNT_ERROR,"没有该用户！");
        }
        if (account.getCode().equals(RoleType.ADMIN.getCode())){
            return Result.resp(ResultType.PERMISSION_DENIED_UPDATE_ADMIN,"无权限修改管理员");
        }
        if (!account.getEnable()) {
            return Result.resp(ResultType.ACCOUNT_DISABLED,"该用户不可用");
        }

        account.setEnable(false);
        accountMapper.updateAccount(account);

        return Result.resp(ResultType.SUCCESS,"删除成功");
    }

    @Override
    public Result<List<Account>> batchSelect(Integer code) {
        List<Account> accounts = accountMapper.batchSelectByCode(code);
        if (accounts == null || accounts.isEmpty()){
            return Result.resp(ResultType.SELECT_ACCOUNT_ERROR,"暂无用户",null);
        }
        return Result.resp(ResultType.SUCCESS,"查询成功",accounts);
    }

    @Override
    public Result<Void> batchDelete(List<String> ids) {
        try {
            accountMapper.batchDelete(ids);
            return Result.resp(ResultType.SUCCESS,"批量删除成功");
        } catch (Exception e) {
            return Result.resp(ResultType.FAIL,"批量删除失败");
        }
    }

    @Override
    public Result<Void> insert(Account account) {
        try {
            accountMapper.insertAccount(account);
            return Result.resp(ResultType.SUCCESS,"添加用户成功");
        } catch (Exception e) {
            return Result.resp(ResultType.FAIL,"添加用户失败");
        }
    }

    private List<Account> csv2Accounts(CsvData rows) {
        List<Account> accounts = new ArrayList<>();
        // 遍历CSV的每一行
        for (CsvRow row : rows) {
            String id = row.get(0);
            String password = row.get(1);
            Integer code = Integer.parseInt(row.get(2));
            Boolean enable = Boolean.parseBoolean(row.get(3));
            String cardNumber = row.get(4);

            // 创建Account对象并添加到列表中
            Account account = new Account(id, password, code, enable, cardNumber);
            accounts.add(account);
        }
        return accounts;
    }
}
