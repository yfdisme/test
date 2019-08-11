package com.test.mytest.stream;

import com.test.mytest.bean.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        list.add(new User("limang",21,173));
        list.add(new User("yfd",20,171));
        list.add(new User("ych",20,176));
        list.add(new User("yhh",42,173));
        list.add(new User("shizong",30,172));
        //返回List集合排序
        List<Integer> list1 = list.stream().sorted(Comparator.comparingInt(User::getAge)).mapToInt(User::getAge).boxed().distinct().collect(Collectors.toList());
        System.out.println(list1);
        Map<Integer, String> map = list.stream().distinct()
                .collect(Collectors.toMap(User::getAge, User::getName,(k1,k2) -> k2));
        System.out.println(map);

        //mpa 根据key值排序 hsahmap无序 通过LinkedHashMap升序
        Map<Integer, String> map1 = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered( e -> map1.put(e.getKey(),e.getValue()));
        System.out.println(map1);

        // Function.identity() 得到对象
        System.out.println(list.stream().distinct()
                .collect(Collectors.toMap(User::getAge, Function.identity(),(k1,k2) -> k2)));
    }
}
