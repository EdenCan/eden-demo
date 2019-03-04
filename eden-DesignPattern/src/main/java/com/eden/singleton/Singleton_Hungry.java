package com.eden.singleton;

/**
 * 饿汉模式
 * 提前实例化对象
 */
public class Singleton_Hungry {

    /**
     * 在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
     */
    private static Singleton_Hungry singletonHungry = new Singleton_Hungry();

    /**
     * 私有化构造方法，避免被外部实例化
     */
    private Singleton_Hungry() {
    }

    /**
     * 静态，不用同步（类加载时已初始化，不会有多线程的问题）
     * @return
     */
    public static Singleton_Hungry getInstance(){

        return singletonHungry;
    }

    public void testMethod(){
        System.out.println("我是饿汉模式，我很饿");
    }
}
