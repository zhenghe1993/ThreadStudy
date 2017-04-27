package com.imp.typedef.lock;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class Lock {

    private boolean isLocked=false;

    private Thread lockingThread=null;
    public synchronized  void lock() throws InterruptedException {
        while(isLocked){
            System.out.println(Thread.currentThread().getName()+":进入阻塞状态" );
            wait();
            System.out.println(Thread.currentThread().getName()+":解除阻塞状态" );
        }
        isLocked=true;
        lockingThread=Thread.currentThread();
    }

    public synchronized  void unlock(){
        if(this.lockingThread!=Thread.currentThread()){
            throw  new IllegalMonitorStateException("Call thread has not locked this lock");
        }
        isLocked=false;
        lockingThread=null;
        notify();
    }



}
