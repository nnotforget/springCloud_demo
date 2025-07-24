package com.spring.storage.service.impl;

import com.spring.storage.mapper.StorageTblMapper;
import com.spring.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageTblMapper storageTblMapper;

    @Transactional  //本地事务 方法上添加的注解
    @Override
    public void deduct(String commodityCode, int count) {
        storageTblMapper.deduct(commodityCode, count);
        if (count == 5) {
            throw  new RuntimeException("库存不足");
        }
    }
}
