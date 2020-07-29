package com.test.mytest.test;

/**
 * @Auther yfd
 * @Date 2020-06-21 8:50
 */
public interface UserService {
    void logIn(String name,String passWord);
    String  register(User user);
}
