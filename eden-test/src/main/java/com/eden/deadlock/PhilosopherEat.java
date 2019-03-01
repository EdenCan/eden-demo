package com.eden.deadlock;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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

        @Override
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
}

