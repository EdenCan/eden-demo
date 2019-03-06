package com.eden.factory.abstractFactory.yellowHuman;

import com.eden.factory.abstractFactory.Human;
import com.eden.factory.abstractFactory.human.AbstractYellowHuman;

public class YellowFemaleHuman extends AbstractYellowHuman implements Human {

    public void sex() {
        System.out.println("该黄种人的性别为女...");
    }
}
