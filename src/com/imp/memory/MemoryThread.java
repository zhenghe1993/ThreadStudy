package com.imp.memory;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/25
 */
public class MemoryThread implements Runnable {


    @Override
    public void run() {
        method1();
    }

    private  void method1() {
        StaticObject staticObject = StaticObject.getInstance();
        staticObject.setA(100);
        staticObject.setB(300);
        System.out.println(Thread.currentThread().getName()+":"+staticObject.getA());
        System.out.println(Thread.currentThread().getName()+":"+staticObject.getB());
    }

}
