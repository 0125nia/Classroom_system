package com.javaee.web.service.impl;

import cn.hutool.core.text.csv.*;
import com.javaee.common.enums.ResultType;
import com.javaee.common.pojo.Account;
import com.javaee.common.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
class AccountServiceImplTest {

    @Test
    void batchInsert() {
        MultipartFile file = new MockMultipartFile("app.csv","2215432,123,1,111,123\n\n\n2215432,123,456,123".getBytes(StandardCharsets.UTF_8));
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            // 创建CSV读取器
            CsvReader csvReader = CsvUtil.getReader(reader, CsvReadConfig.defaultConfig() );

            // 读取CSV内容
            CsvData rows = csvReader.read();
            List<Account> accounts = csv2Accounts(rows);
            System.out.println(accounts.size());
            for (Account account : accounts) {
                System.out.print(account);
                System.out.println(account.getPassword() + " " + account.getCardNumber());
            }
//            accounts.forEach(System.out::println);
//            accountMapper.batchInsert(accounts);

        } catch (Exception e) {
            // 处理异常
            System.out.println("1");
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