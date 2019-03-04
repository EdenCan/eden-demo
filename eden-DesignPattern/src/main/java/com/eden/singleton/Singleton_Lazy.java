package com.eden.singleton;

/**
 * 懒汉模式
 * 需要时才会实例化对象
 * 比较懒，在类加载时，不创建实例，因此类加载速度快，但运行时获取对象的速度慢
 */
public class Singleton_Lazy {

    /**
     * 静态私用成员，没有初始化
     */
    private static Singleton_Lazy singletonLazy = null;

    /**
     * 私有化构造方法
     */
    private Singleton_Lazy() {
    }

    /**
     * 静态，同步，公开访问点
     * 注意：此处添加synchronized 是为了在多线程下还是线程安全的
     * @return
     */
    public static synchronized Singleton_Lazy getSingletonLazy(){
        if(singletonLazy == null){
            singletonLazy = new Singleton_Lazy();
        }
        return singletonLazy;
    }

    public void testMethod(){
        System.out.println("我是懒汉模式，我很懒");
    }
}
