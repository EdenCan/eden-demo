package com.eden.factory.factoryMethodNvwa;

/**
 * 自带体味的白种人
 */
public class WhiteHuman implements Human {
    public void talk() {
        System.out.println("我们要学习汉语，ABC没内涵");
    }

    public void cry() {
        System.out.println("哭吧哭吧，都是泪");
    }

    public void laugh() {
        System.out.println("笑吧笑吧，傻啦吧唧的");
    }
}
