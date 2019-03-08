package com.eden.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private IMonkey iMonkey;

    public ProxyHandler(IMonkey iMonkey) {
        this.iMonkey = iMonkey;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
        System.out.println("method :"+ method.getName()+" is invoked!");
        Object result = method.invoke(iMonkey, args);
        System.out.println("====after====");
        return result;
    }
}
