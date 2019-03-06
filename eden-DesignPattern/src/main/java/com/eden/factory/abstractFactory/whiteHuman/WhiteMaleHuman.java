package com.eden.factory.abstractFactory.whiteHuman;

import com.eden.factory.abstractFactory.Human;
import com.eden.factory.abstractFactory.human.AbstractWhiteHuman;

public class WhiteMaleHuman extends AbstractWhiteHuman implements Human {

    public void sex() {
        System.out.println("该白种人的性别为男....");
    }
}
