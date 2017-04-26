package com.imp.thread_local;

import java.util.Random;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class MyThreadLocal {

    public static void main(String[] args) {

        MyThreadLocalRun myThreadLocalRun=new MyThreadLocal().new MyThreadLocalRun();
        new Thread(myThreadLocalRun).start();
        new Thread(myThreadLocalRun).start();


    }




    private class MyThreadLocalRun implements Runnable{

        private ThreadLocal<Integer> threadLocal=new ThreadLocal<>();

        @Override
        public void run() {

         threadLocal.set((int) (Math.random()*100));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());

        }
    }

}
