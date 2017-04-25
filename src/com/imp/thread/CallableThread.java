package com.imp.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by (IMP)郑和明
 * Date is 2017/4/25
 */
public class CallableThread implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "imp";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThread thread = new CallableThread();
        FutureTask<String> ft = new FutureTask<>(thread);
        new Thread(ft).start();
        System.out.println(ft.get());

    }

}
