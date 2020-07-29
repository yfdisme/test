package com.test.mytest.test;

import lombok.Data;

/**
 * @Auther yfd
 * @Date 2020-06-21 8:51
 */
@Data
public class User {
    private String name;
    private String passWord;

    public User(String yfd, String s) {
        this.name = yfd;
        this.passWord = s;
    }
}
