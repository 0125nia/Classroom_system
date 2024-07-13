package com.javaee.web.service;

import com.javaee.common.pojo.Maintain;
import com.javaee.common.pojo.Result;

import java.util.List;

public interface MaintainService {
    Result<List<Maintain>> getAll();
    Result<Void> insert(Maintain maintain);
    Result<Void> update(Maintain maintain);
    Result<Void> delete(Integer id);
}
