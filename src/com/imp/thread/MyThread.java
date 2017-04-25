package com.imp.thread;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/25
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

}
