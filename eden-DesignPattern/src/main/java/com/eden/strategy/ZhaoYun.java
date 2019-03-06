package com.eden.strategy;

/**
 * 使用策略
 */
public class ZhaoYun {

    /**
     * 赵云出场了，他根据诸葛亮给他的交代，依次拆开妙计
     */
    public static void main(String[] args) {
        StrategyBox strategyBox;
        //刚刚到吴国的时候拆第一个
        System.out.println("-----------刚刚到吴国的时候拆第一个-------------");
        strategyBox = new StrategyBox(new OneStrategy()); //拿到妙计
        strategyBox.operate(); //拆开执行
        System.out.println("\n\n\n");//刘备乐不思蜀了，拆第二个了
        System.out.println("-----------刘备乐不思蜀了，拆第二个了-------------");
        strategyBox = new StrategyBox(new TwoStrategy());
        strategyBox.operate(); //执行了第二个锦囊了
        System.out.println("\n\n\n");

        //孙权的小兵追了，咋办？拆第三个
        System.out.println("-----------孙权的小兵追了，咋办？拆第三个-------------");
        strategyBox = new StrategyBox(new ThreeStrategy());
        strategyBox.operate(); //孙夫人退兵
        System.out.println("\n\n\n");

        /*
        *问题来了：赵云实际不知道是那个策略呀，他只知道拆第一个锦囊，
        *而不知道是BackDoor这个妙计，咋办？ 似乎这个策略模式已经把计谋名称写出来了
        *
        * 错！BackDoor、GivenGreenLight、BlockEnemy只是一个代码，你写成first、second、third，没人会说你错!
        *
        * 策略模式的好处就是：体现了高内聚低耦合的特性呀，缺点嘛，这个那个，我回去再查查
        */
    }
}
