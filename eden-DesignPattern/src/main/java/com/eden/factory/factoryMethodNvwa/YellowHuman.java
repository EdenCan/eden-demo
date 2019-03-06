package com.eden.factory.factoryMethodNvwa;

/**
 * 定义最高贵的人种：黄种人
 */
public class YellowHuman implements Human {
    public void talk() {
        System.out.println("我们是说汉语的，汉语是世界上最好的语种");
    }

    public void cry() {
        System.out.println("哭，那是不可能哭的，要哭也是让傻逼RB人哭");
    }

    public void laugh() {
        System.out.println("小RB人是猪，认同的爆笑吧");
    }
}
