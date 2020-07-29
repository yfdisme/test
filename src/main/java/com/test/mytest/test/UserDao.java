package com.test.mytest.test;

/**
 * @Auther yfd
 * @Date 2020-06-21 8:50
 */
public class UserDao {
    public void logIn(String name,String passWord){
        System.out.println("userName="+name+"passWord="+passWord);
    }

    public String register(User user){
       // System.out.println();
        return user.toString();
    }
}
