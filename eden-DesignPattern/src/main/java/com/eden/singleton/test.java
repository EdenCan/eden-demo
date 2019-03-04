package com.eden.singleton;

public class test {

    public static void main(String[] args) {

        Singleton_Lazy singletonLazy = Singleton_Lazy.getSingletonLazy();
        singletonLazy.testMethod();


        Singleton_Hungry singletonHungry = Singleton_Hungry.getInstance();
        singletonHungry.testMethod();

    }

}
