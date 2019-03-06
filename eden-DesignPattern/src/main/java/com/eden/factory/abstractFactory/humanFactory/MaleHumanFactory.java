package com.eden.factory.abstractFactory.humanFactory;

import com.eden.factory.abstractFactory.AbstractHumanFactory;
import com.eden.factory.abstractFactory.Human;
import com.eden.factory.abstractFactory.HumanEnum;

public class MaleHumanFactory extends AbstractHumanFactory{

    //创建一个男性黑种人
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }
    //创建一个男性白种人
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHuman);
    }
    //创建一个男性黄种人
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YelloMaleHuman);
    }
}
