package com.imp.memory;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/25
 */
public class Main {

    public static void main(String[] args) {
           new Thread(new MemoryThread(),"imp").start();
           new Thread(new MemoryThread(),"admin").start();

        StaticObject staticObject=StaticObject.getInstance();

        System.out.println(Thread.currentThread().getName()+":"+staticObject.getA());
        System.out.println(Thread.currentThread().getName()+":"+staticObject.getB());
    }
}
