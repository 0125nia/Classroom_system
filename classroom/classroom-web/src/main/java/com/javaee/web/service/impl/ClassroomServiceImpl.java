package com.javaee.web.service.impl;

import com.javaee.common.enums.ResultType;
import com.javaee.common.pojo.Classroom;
import com.javaee.common.pojo.Result;
import com.javaee.web.mapper.ClassroomMapper;
import com.javaee.web.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public List<Classroom> getClassroomDetails(Integer id) {
        return classroomMapper.getClassrooms(id);
    }

    @Override
    public Result<Void> insertClassroom(String bid, String name) {
        classroomMapper.insertClassroom(bid,name);
        return Result.resp(ResultType.SUCCESS,"添加成功");
    }

    @Override
    public Result<Void> update(Classroom classroom) {
        classroomMapper.updateClassroom(classroom);
        return Result.resp(ResultType.SUCCESS,"修改成功");
    }
}