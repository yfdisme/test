package com.test.mytest.test;

import org.junit.Test;

/**
 * @Auther yfd
 * @Date 2020-06-21 9:03
 */

public class test {
    @Test
    public void test1(){
       UserService userService;
        userService = new UserServiceImpl();
        userService.logIn("yfd","123456");
        User yfd = new User("yfd", "12345678");
        System.out.println(userService.register(yfd));
    }
}
