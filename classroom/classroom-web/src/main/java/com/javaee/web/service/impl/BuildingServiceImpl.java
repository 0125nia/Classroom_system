package com.javaee.web.service.impl;

import com.javaee.web.mapper.BuildingMapper;
import com.javaee.web.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<String> select() {
        return buildingMapper.select();
    }
}
