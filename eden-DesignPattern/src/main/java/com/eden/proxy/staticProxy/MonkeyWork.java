package com.eden.proxy.staticProxy;

/**
 * 已经有工作的猴子代理了找工作的猴子给老板吹牛逼
 */
public class MonkeyWork implements IMonkey {

    private IMonkey iMonkey;

    /**
     * 默认肯定得给我的猿朋友内推啦
     */
    public MonkeyWork() {
        this.iMonkey = new MonkeyInterview();
    }

    /**
     * 有了我就可以给任何想来我们公司的猿做内推啦
     * @param iMonkey
     */
    public MonkeyWork(IMonkey iMonkey) {
        this.iMonkey = iMonkey;
    }

    /**
     *  我现在已经有工作啦，就不用再和老板吹嘘我会写代码啦
     */
    public void writeCode() {
        this.iMonkey.writeCode();
    }

    /**
     * 我已经入职啦，我的聪明一直都在。我需要给我的内推人员包装下拉
     */
    public void cleverness() {
        this.iMonkey.cleverness();
    }
}
