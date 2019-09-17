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
}
