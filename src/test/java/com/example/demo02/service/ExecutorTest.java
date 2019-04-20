package com.example.demo02.service;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Alexchs
 * @Description:
 * @Date: created in 2:05 2019-04-21
 * @ModifiedBy:
 * @URL:
 */
public class ExecutorTest {
    @Test
    public void testExecutorCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0 ; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0 ; i < 6 ; i++) {
                        System.out.println("this is "+Thread.currentThread() + " number : " + i);
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
