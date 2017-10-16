package com.wanwan.common.util.threadpool;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.*;

/**
 * Created by c_zhangyayun-001 on 2017/10/13.
 */
public class TestThreadPool {
    private static final int NTHREDS = 10;

    // 计算 1-100 的和 分给10个线程来做
    public static void main(String[] args) {
        //声明10个线程
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        //每个线程执行 10个数的和，10个线程并发
        for(int i=0; i < NTHREDS; i++){

            Future<Integer> submit = executor.submit(new MyCallable(i*NTHREDS+1, (i+1)*NTHREDS));
            futureList.add(submit);
        }
        long sum = 0;
        // 把十个结果相加
        for(Future<Integer> future : futureList){
            try{
                sum += future.get();
            }catch (InterruptedException e1){
                e1.printStackTrace();
            }catch(ExecutionException e2){
                e2.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("sum = " + sum);
    }
}
