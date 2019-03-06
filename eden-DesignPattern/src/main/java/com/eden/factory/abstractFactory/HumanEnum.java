package com.eden.factory.abstractFactory;

/**
 * java enum类型尽量简单使用，尽量不要使用多态、继承等方法
 * 毕竟用Class完全可以代替enum
 *
 *  好处：
 * Enum 类型作为一个参数传递到一个方法中时，在 Junit 进行单元测试的时候，
 * 不用判断输入参数是否为空、长度为 0 的边界异常条件，如果方法传入的参数不是 Enum 类型的话，
 * 根本就传递不进来，你说定义一个类，定义一堆的静态变量，这也可以呀，这个不和你抬杠，
 * 上面的代码我解释一下，构造函数没啥好说的，然后是 getValue()方法，就是获得枚举类型中一个元素的值，
 * 枚举类型中的元素也是有名称和值的，这个和 HashMap 有点类似。
 */
public enum HumanEnum {

    //把世界上所有人类型都定义出来
    YelloMaleHuman("com.eden.factory.abstractFactory.yellowHuman.YellowMaleHuman"),

    YelloFemaleHuman("com.eden.factory.abstractFactory.yellowHuman.YellowFemaleHuman"),

    WhiteFemaleHuman("com.eden.factory.abstractFactory.whiteHuman.WhiteFemaleHuman"),

    WhiteMaleHuman("com.eden.factory.abstractFactory.whiteHuman.WhiteMaleHuman"),

    BlackFemaleHuman("com.eden.factory.abstractFactory.blackHuman.BlackFemaleHuman"),

    BlackMaleHuman("com.eden.factory.abstractFactory.blackHuman.BlackMaleHuman");

    private String value = "";
    //定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }



}
