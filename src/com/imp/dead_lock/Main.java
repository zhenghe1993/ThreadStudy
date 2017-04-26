package com.imp.dead_lock;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class Main {


    public static void main(String[] args) {

        Main main = new Main();
        ClothesFactory factory = new ClothesFactory();

        new Thread(main.new FactoryRun(factory)).start();
        new Thread(main.new FactoryStop(factory)).start();


    }


    class FactoryRun implements Runnable {

        private ClothesFactory factory;

        public FactoryRun(ClothesFactory factory) {
            this.factory = factory;
        }

        @Override
        public void run() {

            while (true) {
                factory.product();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class FactoryStop implements Runnable {

        private ClothesFactory factory;

        public FactoryStop(ClothesFactory factory) {
            this.factory = factory;
        }

        @Override
        public void run() {

            while (true) {
                factory.custom();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }

}



