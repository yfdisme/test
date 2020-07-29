package com.test.mytest.bean;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Demo02 {
    AtomicStampedReference<Thread> atomicStampedReference = new AtomicStampedReference<>(null,1);
    public static void main(String[] args) {
        new Thread(()->{},"t1").start();
    }

    public static void mylock(){

    }
}
