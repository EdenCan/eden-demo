package com.eden.factory.abstractFactory;

/**
 * 定义一个人类的统称和人类的一些特征特性
 */
public interface Human {

    /**
     * 人类可以说话
     */
    public void talk();

    /**
     * 人类可以哭
     */
    public void cry();

    /**
     * 人类可以爆笑
     */
    public void laugh();

    /**
     * 人类有男女的性别
     */
    public void sex();

}
