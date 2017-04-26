package com.imp.dead_lock;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/26
 */
public class ClothesFactory {


    private int count;



    //生产者


    public synchronized void product() {

        count++;
        System.out.println("已生产一件衣服 ，现存衣服 " + count);
        custom();
    }

    //消费者

    public  void custom() {

        synchronized (ClothesFactory.class){
            count--;
            System.out.println("已消费一件衣服 ，现存衣服 " + count);
            product();
        }

    }


}
