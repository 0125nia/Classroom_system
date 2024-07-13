package com.javaee.web.controller;

import com.javaee.common.enums.ResultType;
import com.javaee.common.enums.RoleType;
import com.javaee.common.pojo.Account;
import com.javaee.common.pojo.Classroom;
import com.javaee.common.pojo.Result;
import com.javaee.web.service.AccountService;
import com.javaee.web.service.ClassroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * @author nia
 * @description
 * @Date 2024/6/28
 */
@Api(tags = "管理员")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "批量导入", notes = "上传csv文件，导入文件中的用户信息")
    @PostMapping("/batch/import")
    public Result<Void> batchImport(@RequestParam("file")MultipartFile file){
        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".csv")){
            return Result.resp(ResultType.FAIL,"导入的文件类型必须为csv!");
        }
        return accountService.batchInsert(file);
    }

    @ApiOperation(value = "删除用户",notes = "逻辑删除，将修改启用标志")
    @GetMapping("/del/{id}")
    public Result<Void> delAccount(@PathVariable String id){
        return accountService.logicallyDelete(id);
    }

    @ApiOperation(value = "批量删除",notes = "批量逻辑删除用户")
    @PostMapping("/batch/del")
    public Result<Void> batchDel(List<String> ids){
        return accountService.batchDelete(ids);
    }

    @ApiOperation(value = "添加用户",notes = "添加用户信息")
    @PostMapping("/import")
    public Result<Void> importAccount(Account account){
        return accountService.insert(account);
    }

    @ApiOperation(value = "批量查询用户",notes = "根据类型，查询所有可用用户")
    @GetMapping("/batch/select/{code}")
    public Result<List<Account>> batchSelect(@PathVariable Integer code){
        if (code.equals(RoleType.ADMIN.getCode())){
            return Result.resp(ResultType.PERMISSION_DENIED,ResultType.PERMISSION_DENIED.getMsg(),null);
        }
        return accountService.batchSelect(code);
    }

    @ApiOperation(value = "添加教室",notes = "添加教学楼对应的教室")
    @GetMapping("/classroom/insert")
    public Result<Void> insertClassroom(@PathVariable String bid, @PathVariable String name){
        return classroomService.insertClassroom(bid,name);
    }

    @ApiOperation(value = "修改教室信息",notes = "根据前端表单修改教室信息")
    @PostMapping("/classroom/update")
    public Result<Void> updateClassroom(Classroom classroom){
        return classroomService.update(classroom);
    }

}
