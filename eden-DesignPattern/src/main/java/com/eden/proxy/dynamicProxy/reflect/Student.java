package com.eden.proxy.dynamicProxy.reflect;

/**
 * 创建一个被反射的对象
 */
public class Student {

    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}