package com.javaee.web.service;

import com.javaee.common.pojo.Classroom;
import com.javaee.common.pojo.Result;

import java.util.List;


public interface ClassroomService {

    List<Classroom> getClassroomDetails(Integer id);

    Result<Void> insertClassroom(String bid, String name);

    Result<Void> update(Classroom classroom);
}
