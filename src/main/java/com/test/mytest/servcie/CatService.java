package com.test.mytest.servcie;

import com.test.mytest.bean.Cat;

public interface CatService {
    public int insertCar(Cat catPo) ;
    public Cat searchCat(Cat cat);
    public int deleteCat(Cat cat);
}
