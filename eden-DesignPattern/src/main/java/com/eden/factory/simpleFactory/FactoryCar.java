package com.eden.factory.simpleFactory;

/**
 * 工厂类中存储所有car的实例
 */
public class FactoryCar {

    public ICar getCar(CarType carType){
        switch (carType){
            case JeepCarType:
                return new JeepCar();
            case SportCarType:
                return new SportCar();
            case HatchbackCarType:
                return new HatchbackCar();
            default:
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
