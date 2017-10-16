package com.wanwan.common.util.threadpool;

import java.util.concurrent.Callable;

/**
 * Created by c_zhangyayun-001 on 2017/10/13.
 */
public class MyCallable implements Callable<Integer> {
    private Integer start;
    private Integer end;
    public MyCallable(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for(int i = start; i <= end; i++){
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " " +start + "-" + end + "=" + sum);
        return sum;
    }
}
