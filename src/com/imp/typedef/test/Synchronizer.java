package com.imp.typedef.test;

import com.imp.typedef.lock.FairLock;

import java.util.concurrent.TimeUnit;


/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class Synchronizer {
   private FairLock lock=new FairLock();


    public void doSynchronized() throws InterruptedException {

        lock.lock();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName()+"  开始执行任务");

        lock.unlock();
    }

}
