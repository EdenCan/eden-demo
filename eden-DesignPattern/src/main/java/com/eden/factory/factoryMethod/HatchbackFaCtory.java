package com.eden.factory.factoryMethod;

public class HatchbackFaCtory implements IFactory {

    public ICar CreatCar() {
        return new HatchbackCar();
    }
}
