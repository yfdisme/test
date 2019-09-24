package com.test.mytest.servcie.impl;

import com.test.mytest.bean.Cat;
import com.test.mytest.dao.CatMapper;
import com.test.mytest.dao.UserMapper;
import com.test.mytest.servcie.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatMapper catMapper;

    @Autowired
    private UserMapper userMapper;
    //增加一条记录
    @Override
    public int insertCar(Cat catPo) {
        return catMapper.insertCat(catPo);
    }

    //按ad查询
    @Override
    public Cat searchCat(Cat cat) {
        return catMapper.searchCat(cat);
    }

    @Override
    public int deleteCat(Cat cat) {
        return catMapper.deleteCat(cat);
    }
}
