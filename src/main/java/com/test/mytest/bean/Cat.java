package com.test.mytest.bean;

import lombok.Data;

import java.util.Date;
@Data
public class Cat {
    private Integer catID;
    private String name;
    private Integer age;
    private String address;
    private String catType;
    private Date catBrithday;
}
