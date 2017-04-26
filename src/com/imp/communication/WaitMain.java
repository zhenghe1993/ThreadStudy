package com.imp.communication;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class WaitMain {


    public static void main(String[] args) {

        WaitMain main=new WaitMain();
        new Thread(main.new SendRun()).start();
        new Thread(main.new ReceRun()).start();


    }


     class SendRun implements Runnable {

        @Override
        public void run() {


            for (int i = 0; i < 10; i++) {
            synchronized (WaitMain.class) {
                try {
                    Thread.sleep(1000);
                    if (i == 4) {

                        WaitMain.class.wait();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run ---  " + i);
            }
            }
        }
    }


    class ReceRun implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            synchronized (WaitMain.class) {
            WaitMain.class.notifyAll();}
        }
    }
}
