package com.test.mytest;

import com.test.mytest.bean.Cat;
import com.test.mytest.bean.User;
import org.apache.logging.log4j.util.LambdaUtil;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class testMain {
    private static Map<Integer,Function<Integer,Cat>> map = new HashMap<>();
    public static void main(String[] args) {

                boolean flag = 10%2 == 1 && 10 / 3 == 0 && 1 / 0 == 0 ;
                System.out.println(flag ? "mldn" : "yootk") ;


        /**
         * function函数减少if else语句
         */
//        map.put(1,integer -> { Cat cat = new Cat();
//        cat.setAge(11);
//        return cat;
//        });
//        map.put(2,integer -> { Cat cat = new Cat();
//            cat.setAge(12);
//            return cat;
//        });
//        map.put(3,integer -> { Cat cat = new Cat();
//            cat.setAge(13);
//            return cat;
//        });
//
//        System.out.println(map.get(2).apply(2));

//        List a = new ArrayList<Cat>();
//        a.add(new Cat(1,"a","a","a",new Date()));
//        a.add(new Cat(2,"b","b","b",new Date()));
//        a.add(new Cat(3,"c","c","c",new Date()));
//        a.add(new Cat(4,"d","d","d",new Date()));
//
//        Iterator iterator = a.iterator();
//        if (iterator.hasNext()){
//            Cat next = (Cat)iterator.next();
//            if("a".equals(next.getCatType())){
//                iterator.remove();
//            }
//        }
//
//        a.forEach(System.out::print);
//        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
//        hash.put(10,20);
//        hash.put(5,21);
//        hash.put(1,7);
//        List<Map.Entry<Integer, Integer>> collect = new ArrayList<Map.Entry<Integer, Integer>>(hash.entrySet());
//        SortMap(collect);
//        List<Map.Entry<Integer, Integer>> entryList = collect.stream().collect(Collectors.toList());
//
//            entryList.stream().sorted();

    }
    public static void SortMap(List<Map.Entry<Integer,Integer>> listMap){
        Collections.sort(listMap, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        System.out.println(listMap);
    }
}
