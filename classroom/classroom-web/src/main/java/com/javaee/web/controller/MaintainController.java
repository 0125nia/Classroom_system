package com.javaee.web.controller;

import com.javaee.common.pojo.Maintain;
import com.javaee.common.pojo.Result;
import com.javaee.web.service.MaintainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "维修信息")
@RestController
@RequestMapping("/maintain")
public class MaintainController {
    @Autowired
    private MaintainService maintainService;

    @ApiOperation(value = "所有报修信息",notes = "获取用户上报的所有保修信息")
    @GetMapping("/all")
    public Result<List<Maintain>> getAll() {
        return maintainService.getAll();
    }

    @ApiOperation(value = "报修",notes = "用户上报教室维护信息")
    @PostMapping("/insert")
    public Result<Void> add(@RequestBody Maintain maintain) {
        return maintainService.insert(maintain);
    }

    @ApiOperation(value = "更新维修信息",notes = "修改对应的维修信息")
    @PutMapping("/update")
    public Result<Void> update(@RequestBody Maintain maintain) {
        return maintainService.update(maintain);
    }

    @ApiOperation(value = "删除报修信息",notes = "根据id删除教室维修信息")
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        return maintainService.delete(id);
    }
}
