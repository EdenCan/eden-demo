package com.eden.strategy;

/**
 * 计谋有了，那还要有锦囊
 */
public class StrategyBox {

    /**
     * 构造函数，你要使用那个妙计
     */
    private IStrategy straegy;
    public StrategyBox(IStrategy strategy){
        this.straegy = strategy;
    }

    /**
     * 使用计谋了，看我出招了
     */
    public void operate(){
        this.straegy.operate();
    }

}
