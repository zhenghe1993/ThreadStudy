package com.imp.typedef.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class FairLock {

    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized (this) {
            waitingThreads.add(queueObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
                System.out.println(Thread.currentThread().getName()+ " :  isLocked ="+isLocked+",isLockedForThisThread="+isLockedForThisThread);
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try {
                System.out.println(Thread.currentThread().getName()+" : 进入阻塞状态");
                queueObject.doWait();
                System.out.println(Thread.currentThread().getName()+" : 退出阻塞状态");
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queueObject);
                }
                throw e;
            }
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }
}
