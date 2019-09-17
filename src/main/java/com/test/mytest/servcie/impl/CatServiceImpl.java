package com.test.mytest.servcie.impl;

import com.test.mytest.bean.Cat;
import com.test.mytest.dao.CatMapper;
import com.test.mytest.servcie.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatMapper catMapper;

    //增加一条记录
    @Override
    public int insertCar(Cat catPo) {
        return catMapper.insertCat(catPo);
    }
}
