package com.eden.proxy.staticProxy;

/**
 * 我是boss，用人我说了算
 */
public class Boss {

    public static void main(String[] args) {

        System.out.println("========= 内推猿朋友 =================");
        //boos来了，喊来在工作的猿。小子，过来和我说说你内推的那个猿
        MonkeyWork monkeyWork = new MonkeyWork();

        //好的，boss。这个猿很优秀
        monkeyWork.cleverness();
        monkeyWork.writeCode();

        System.out.println("============== 一段时间后 内推炮灰猿===========");
        /**
         * 过了一段时间，猿发现内推居然有奖励，他就在boss直聘上找了一个候选人：炮灰内推
         */
        //炮灰将简历给到工作猿
        MonkeyPaohui monkeyPaohui = new MonkeyPaohui();

        //boos来了，喊来在工作的猿。小子，过来和我说说你内推的那个炮灰猿
        MonkeyWork monkeyPaoHui = new MonkeyWork(monkeyPaohui);

        monkeyPaoHui.cleverness();
        monkeyPaoHui.writeCode();

    }
}
