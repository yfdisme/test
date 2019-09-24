package com.test.mytest.controller;

import com.test.mytest.bean.UserDto;
import com.test.mytest.dao.CatMapper;
import com.test.mytest.dao.UserMapper;
import com.test.mytest.utils.AcctResult;
import com.test.mytest.utils.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/login")
    public AcctResult<String> login(@RequestBody UserDto user,HttpServletResponse httpServletResponse) throws Exception{
        UserDto user1 = userMapper.selectOne(user);
        if (user1.getUsername() == null) {
            return AcctResult.resultSuccessful("无用户");
        } else if (!user1.getPassword().equals(user.getPassword())) {
            return AcctResult.resultSuccessful("密码错误");
        } else {
            String token = JWTUtil.sign(user1.getUsername(),user1.getPassword());
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return AcctResult.resultSuccessful(token);
        }
    }

    @RequestMapping("/index1")
    public AcctResult<String> index1(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return AcctResult.resultSuccessful("aaaa");
        }else{

        return AcctResult.resultSuccessful("CCCC");
        }
    }
}