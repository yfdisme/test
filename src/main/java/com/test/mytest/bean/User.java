package com.test.mytest.bean;

public class User {
    private String name;
    private int age;
    private double highe;

    public User(String name, int age, double highe) {
        this.name = name;
        this.age = age;
        this.highe = highe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHighe() {
        return highe;
    }

    public void setHighe(double highe) {
        this.highe = highe;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", highe=" + highe +
                '}';
    }
}
