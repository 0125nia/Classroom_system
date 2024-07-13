package com.javaee.web.controller;

import com.javaee.common.enums.ResultType;
import com.javaee.common.pojo.Classroom;
import com.javaee.common.pojo.Result;
import com.javaee.web.service.BuildingService;
import com.javaee.web.service.ClassroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "教室管理")
@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private ClassroomService classroomService;

    @ApiOperation(value = "获取教学楼",notes = "获取所有教学楼")
    @GetMapping("/buildings")
    public Result<List<String>> getBuildings() {
        return Result.resp(ResultType.SUCCESS, "请求成功", buildingService.select());
    }
    @ApiOperation(value = "获取教室",notes = "获取教学楼对应教室详细信息")
    @GetMapping("/detail/{id}")
    public Result<List<Classroom>> classroomDetails(@PathVariable Integer id){
        return Result.resp(ResultType.SUCCESS,"获取教室详情",classroomService.getClassroomDetails(id));
    }
}
