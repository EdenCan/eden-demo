package com.eden.factory.factoryMethod;

public class SportFaCtory implements IFactory {

    public ICar CreatCar() {
        return new SportCar();
    }
}
