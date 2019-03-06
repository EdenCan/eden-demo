package com.eden.factory.abstractFactory;

import com.eden.factory.abstractFactory.humanFactory.FemaleHumanFactory;
import com.eden.factory.abstractFactory.humanFactory.MaleHumanFactory;

public class nvwaMainTest {

    public static void main(String[] args) {
        //第一条生产线，男性生产线
        HumanFactory maleHumanFactory = new MaleHumanFactory();

        //第二条生产线，女性生产线
        HumanFactory femaleHumanFactory = new FemaleHumanFactory();

        //生产线建立完毕，开始生产人了:
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();

        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();

        System.out.println("黄种男人===================");
        maleYellowHuman.cry();
        maleYellowHuman.laugh();
        maleYellowHuman.sex();

        System.out.println("黄种女人===================");
        femaleYellowHuman.cry();
        femaleYellowHuman.laugh();
        femaleYellowHuman.sex();
    }
}
