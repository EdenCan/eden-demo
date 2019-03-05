package com.eden.factory.factoryMethod;

public class JeepFaCtory implements IFactory {

    public ICar CreatCar() {
        return new JeepCar();
    }
}
