package com.eden.factory.simpleFactory;

/**
 * 定义汽车类型枚举
 */
public enum CarType {

    SportCarType(0),//跑车
    JeepCarType(1),//jeep
    HatchbackCarType(2);//两箱车

    private final int name;

    private CarType(int name)
    {
        this.name = name;
    }

    public int getName() {
        return name;
    }
}