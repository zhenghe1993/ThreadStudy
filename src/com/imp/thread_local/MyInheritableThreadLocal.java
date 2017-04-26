package com.imp.thread_local;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class MyInheritableThreadLocal {


    public static void main(String[] args) throws InterruptedException {


        ThreadLocal<String> localString = new InheritableThreadLocal<>();

        localString.set("imp");

        ThreadLocal<StringBuffer> localBuffer=new InheritableThreadLocal<>();

        localBuffer.set(new StringBuffer("IMP"));


        System.out.println(Thread.currentThread().getName()+" : "+localString.get());
        System.out.println(Thread.currentThread().getName()+" : "+localBuffer.get().toString());

        for(int i=0;i<2;i++){

            new Thread(() -> {

                System.out.println(Thread.currentThread().getName()+" : "+localString.get());

                System.out.println(Thread.currentThread().getName()+" : "+localBuffer.get().toString());

            },"IMP--"+i).start();

            new Thread(() -> {

                localString.set("admin");
                localBuffer.set(new StringBuffer("admin"));

                System.out.println(Thread.currentThread().getName()+" : "+localString.get());

                System.out.println(Thread.currentThread().getName()+" : "+localBuffer.get().toString());

            },"Admin--"+i).start();
        }

        Thread.sleep(2000);


        System.out.println(Thread.currentThread().getName()+" : "+localString.get());
        System.out.println(Thread.currentThread().getName()+" : "+localBuffer.get().toString());
    }


}
