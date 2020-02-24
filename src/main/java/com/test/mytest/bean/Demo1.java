package com.test.mytest.bean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Demo1 {
    //java可以开启线程吗？不能
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10,1);
    public static void main(String[] args) {
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           atomicStampedReference.compareAndSet(10, 11, atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);

        }).start();


        new Thread(()->{

        }).start();
        AtomicInteger atomicInteger = new AtomicInteger(3);
        //期望 更新 如果是3就变成5
        System.out.println(atomicInteger.compareAndSet(3, 5));
        System.out.println(atomicInteger.compareAndSet(3, 5));
    }
}
