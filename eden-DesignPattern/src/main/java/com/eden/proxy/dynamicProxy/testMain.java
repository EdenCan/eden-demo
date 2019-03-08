package com.eden.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class testMain {

    public static void main(String[] args) {
        //1.创建委托对象
        Monkey monkey = new Monkey();

        //2.创建调用处理器对象
        ProxyHandler handler = new ProxyHandler(monkey);

        //3.动态生成代理对象
        IMonkey iMonkey = (IMonkey) Proxy.newProxyInstance(Monkey.class.getClassLoader(),
                Monkey.class.getInterfaces(), handler);

        //4.通过代理对象调用方法
        iMonkey.writeCode();
    }
}
