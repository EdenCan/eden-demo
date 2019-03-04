package com.eden.factory.simpleFactory;

public class test {

    public static void main(String[] args) {


        //创建存储car的工厂
        FactoryCar factoryCar = new FactoryCar();
        //提出使用工厂中car的需求
        System.out.println("给我一辆跑车");
        //实例化对应car的实现类
        ICar iCar = factoryCar.getCar(CarType.SportCarType);
        //完成getCar的需求
        iCar.GetCar();
    }
}
