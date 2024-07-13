package com.javaee.web.controller;

import com.javaee.common.enums.ResultType;
import com.javaee.common.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apiguardian.api.API;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "测试接口")
public class HelloController {
    @ApiOperation(value = "测试接口")
    @GetMapping("/")
    public Result<Void> hello(){
        return Result.resp(ResultType.SUCCESS,"成功");
    }
}
