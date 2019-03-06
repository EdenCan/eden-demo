package com.eden.factory.abstractFactory.blackHuman;

import com.eden.factory.abstractFactory.Human;
import com.eden.factory.abstractFactory.human.AbstractBlackHuman;

public class BlackMaleHuman extends AbstractBlackHuman  implements Human {

    public void sex() {
        System.out.println("该黑种人的性别为男...");
    }
}
