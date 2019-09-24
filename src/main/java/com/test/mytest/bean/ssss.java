package com.test.mytest.bean;

import javafx.scene.effect.SepiaTone;
import org.springframework.util.StringUtils;

import java.lang.management.BufferPoolMXBean;
import java.util.*;
import java.util.stream.Collectors;

public class ssss {

    public static void main(String[] args) {
        String a ="hello";
        String b = "he"+new String("llo");
        System.out.println(2<<2);
    }

    public static int aaa(String string){
        Set set =  new HashSet<String>();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i<string.length();i++){
            char a = string.charAt(i);
            if(set.add(a)){
                str.append(a);
            }
        }
        String string1 = set.toString();
        System.out.println(str);
        return str.length();
    }


}
