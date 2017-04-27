package com.imp.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class Main {


    public static void main(String[] args) {
        LockFactory lockFactory=new LockFactory();
        new Thread(new FairLockThread(lockFactory)).start();
        new Thread(new FairLockThread(lockFactory)).start();
    }


}


class FairLockThread implements Runnable{

  private LockFactory lockFactory;

    public FairLockThread(LockFactory lockFactory) {
        this.lockFactory = lockFactory;
    }

    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockFactory.add();
        }

    }


}


class LockFactory{

    private int count;

    private Lock lock=new ReentrantLock();

    public void add(){
        this.lock.lock();
        ++this.count;
        System.out.println(Thread.currentThread().getName()+" : "+this.count);
        this.lock.unlock();
    }



}