package com.javaee.web.service.impl;

import com.javaee.common.enums.ResultType;
import com.javaee.common.pojo.Maintain;
import com.javaee.common.pojo.Result;
import com.javaee.web.mapper.MaintainMapper;
import com.javaee.web.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    private MaintainMapper maintainMapper;
    @Override
    public Result<List<Maintain>> getAll() {
        List<Maintain> maintains = maintainMapper.selectAll();
        return Result.resp(ResultType.SUCCESS,"查询成功",maintains);
    }

    @Override
    public Result<Void> insert(Maintain maintain) {
        maintainMapper.insert(maintain);
        return Result.resp(ResultType.SUCCESS,"添加成功");
    }

    @Override
    public Result<Void> update(Maintain maintain) {
        maintainMapper.update(maintain);
        return Result.resp(ResultType.SUCCESS,"修改成功");
    }

    @Override
    public Result<Void> delete(Integer id) {
        maintainMapper.deleteById(id);
        return Result.resp(ResultType.SUCCESS,"删除成功");
    }
}
