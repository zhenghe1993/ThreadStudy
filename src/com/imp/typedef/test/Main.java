package com.imp.typedef.test;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class Main {

    public static void main(String[] args) {
        Synchronizer synchronizer=new Synchronizer();


        Main main=new Main();

        new Thread(main.new Run(synchronizer)).start();
        new Thread(main.new Run(synchronizer)).start();
        new Thread(main.new Run(synchronizer)).start();
        new Thread(main.new Run(synchronizer)).start();

    }

    class Run implements Runnable{

        private Synchronizer synchronizer;

        public Run(Synchronizer synchronizer) {
            this.synchronizer = synchronizer;
        }

        @Override
        public void run() {
            try {
                synchronizer.doSynchronized();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

