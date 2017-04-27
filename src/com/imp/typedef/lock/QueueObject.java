package com.imp.typedef.lock;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class QueueObject {

    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {

        while(!isNotified){
            this.wait();
        }

        this.isNotified = false;

    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    public boolean equals(Object o) {
        return this == o;
    }

}
