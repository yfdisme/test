package com.test.mytest.dao;

import com.test.mytest.bean.Cat;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CatMapper {
    public Integer searchTotalCount(Cat cat);

    public int insertCat(Cat cat);
}
