package com.test.mytest.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class Cat {
    private Integer catID;
    private String name;
    private Integer age;
    private String address;
    private String catType;
    private Date catBrithday;
    private String aaa;
    private String yfd;
}
