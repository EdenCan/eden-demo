package com.eden.proxy.staticProxy;

/**
 * 定义出要找工作猴子
 */
public class MonkeyInterview implements IMonkey {

    /**
     * 猴子很自恋
     */
    public void cleverness() {
        System.out.println("我很聪明，我是一只无所不能的猿");
    }

    /**
     * 猴子开始吹牛啦
     */
    public void writeCode() {
        System.out.println("我是一只猴子，我会写代码，找BUG");
    }
}
