package com.test.mytest.controller;

import com.test.mytest.bean.Cat;
import com.test.mytest.servcie.CatService;
import com.test.mytest.utils.AcctPageData;
import com.test.mytest.utils.AcctResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @RequestMapping(value = "insertCat" ,method = RequestMethod.POST)
    public AcctResult<Integer> insertCat(@RequestBody Cat catPo){
        int state = catService.insertCar(catPo);
        return AcctResult.resultSuccessful(state);
    }

    @RequestMapping(value = "searchCat" ,method = RequestMethod.POST)
    public AcctResult<Cat> searchCat(@RequestBody Cat cat){
        Cat cat1 = catService.searchCat(cat);
        return AcctResult.resultSuccessful(cat);
    }

    @RequestMapping(value = "deleteCat",method = RequestMethod.POST)
    public AcctResult<Integer> deleteCat(@RequestBody Cat cat){
        int state = catService.deleteCat(cat);
        return AcctResult.resultSuccessful(state);
    }
}
