package com.test.mytest.test;

import org.springframework.stereotype.Service;

/**
 * @Auther yfd
 * @Date 2020-06-21 8:50
 */
@Service
public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDao();
    @Override
    public void logIn(String name, String passWord) {
        userDao.logIn(name,passWord);
    }

    @Override
    public String register(User user) {
        return userDao.register(user);
    }
}
