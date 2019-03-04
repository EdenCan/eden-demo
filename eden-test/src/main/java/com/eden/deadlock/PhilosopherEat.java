package com.eden.deadlock;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/sk199048/article/details/50589980
 * 五支筷子，五个人就餐，一双筷子才能吃饭，吃完后放下别人再吃
 */
public class PhilosopherEat {
    /*
     *筷子类
     */
    public static class Chop {
        private volatile boolean taken = false; //筷子状态
        protected ReentrantLock lock = new ReentrantLock(); //定义锁
        Condition isTaken = lock.newCondition();

        //拿起筷子
        public void take() throws InterruptedException {
            lock.lock();
            try {
                while (taken) { //筷子已被其他哲学家拿走
                    isTaken.await();
                }
                taken = true; //标记筷子被拿走
            } finally {
                lock.unlock();
            }
        }

        // 放下筷子
        public  void put() throws InterruptedException {
            lock.lock();
            try {
                taken = false; //放下筷子
                isTaken.signalAll(); //通知邻座的哲学家拿筷子
            } finally {
                lock.unlock();
            }
        }
    }
    /*
     * 哲学家就餐类
     */
    public static class Philosopher implements Runnable {
        private Chop left; //左手的筷子
        private Chop right; //右手的筷子
        private int id; //哲学家编号
        private int ponderFactor; //思考时间
        private Random random = new Random(47);
        //暂停时间,模拟哲学家吃饭用时等
        private void pasue() throws InterruptedException {
            if (ponderFactor == 0) {
                return;
            }
            //TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
            TimeUnit.MILLISECONDS.sleep(10);
        }

        //构造方法
        public Philosopher(Chop left, Chop right, int id, int ponderFactor) {
            this.left = left;
            this.right = right;
            this.id = id;
            this.ponderFactor = ponderFactor;
        }

//        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    System.out.println(this + " " + "thinking");
                    pasue();
                    right.take();
                    System.out.println(this + " " + "take right");
                    left.take();
                    System.out.println(this + " " + "take left");
                    System.out.println(this + " " + "eat");
                    pasue();
                    left.put();
                    System.out.println(this + " " + "put left");
                    right.put();
                    System.out.println(this + " " + "put right");
                }
            } catch (InterruptedException e) {}
        }
    }

    /**
     * 五个人都用右手拿筷子吃饭，会发现每个人只有一只筷子，都吃不了饭。就会死锁
     * 死锁的必要条件有如下四个：（即破坏其中一个条件就可以破坏死锁）
     *  1、一个资源每次只能被一个线程使用，如IO等。               ===很多系统资源如IO等必须是互斥的，破坏互斥条件的成本较大。
     *  2、一个进程因请求资源而阻塞时，对已获得的资源保持不放。     ===可以通过一次性获取所有资源即对需要的资源进行原子申请可以解决死锁问题，这种方式对系统开销较大，不太理想。
     *  3、进程已获得的资源，在未使用完之前，不能强行剥夺。        ===可以通过定时释放占有的资源解决死锁问题，但是这也会带来过多的资源占有释放操作。
     *  4、若干进程之间形成一种头尾相接的循环等待资源关系。        ===一般破坏此条件
     * @param args
     */
    public static void main(String[] args) {
        int size = 5;
        int ponder = 5;
        Chop [] chops = new Chop[5]; //5跟筷子
        for (int i = 0; i < 5; i++) {
            chops[i] = new Chop();
        }
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            pool.execute(new Philosopher(chops[i], chops[(i + 1) % 5], i, ponder));
        }
        try {
            System.out.println("quit");
            System.in.read();
        } catch (IOException e) {}
        pool.shutdown();
    }

    /**
     * 这是解决死锁常用的方法，例如哲学家就餐问题中，最后一个哲学家可以先拿左手的筷子，拿不到就会等待，他右手的筷子就可以供第一个哲学家使用。
     */
//    public static void main(String[] args) {
//        int size = 5;
//        int ponder = 5;
//        Chop [] chops = new Chop[5]; //5跟筷子
//        for (int i = 0; i < 5; i++) {
//            chops[i] = new Chop();
//        }
//        ExecutorService pool = Executors.newCachedThreadPool();
//        for (int i = 0; i < size; i++) {
//            if (i < size - 1) {
//                pool.execute(new Philosopher(chops[i], chops[(i + 1) % 5], i, ponder));
//            } else {
//                pool.execute(new Philosopher(chops[0], chops[i], i, ponder));
//            }
//        }
//        try {
//            System.out.println("quit");
//            System.in.read();
//        } catch (IOException e) {}
//        pool.shutdown();
//    }

}

