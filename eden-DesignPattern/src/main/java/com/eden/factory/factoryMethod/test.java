package com.eden.factory.factoryMethod;

public class test {

    public static void main(String[] args) {

        IFactory factory = null;

        //sport
        factory = new SportFaCtory();
        ICar car = factory.CreatCar();
        car.GetCar();

        //jeep
        factory = new JeepFaCtory();
        ICar car1 = factory.CreatCar();
        car1.GetCar();
    }
}
