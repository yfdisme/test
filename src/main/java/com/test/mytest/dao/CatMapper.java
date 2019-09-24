package com.test.mytest.dao;

import com.test.mytest.bean.Cat;
import com.test.mytest.bean.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CatMapper{
    public Integer searchTotalCount(Cat cat);

    public int insertCat(Cat cat);

    public Cat searchCat(Cat cat);

    public int deleteCat(Cat cat);
}
