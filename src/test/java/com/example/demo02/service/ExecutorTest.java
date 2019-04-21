package com.example.demo02.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.junit.Test;

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
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 6; i++) {
                        System.out.println("this is " + Thread.currentThread() + " number : " + i);
                    }
                }
            });
        }
        executorService.shutdown();
    }

    @Test
    public void testExecutorCachedThreadPoolCallable() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> ftList = new ArrayList<>(5);
        // List<Future<String>> ftList = new LinkedList<Future<String>>();
        LocalDateTime start = LocalDateTime.now();
        System.out.println("start time is : " + start);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            /*            ftList.add(executorService.submit(new Callable<String>() {
                public String call() throws InterruptedException {
                    System.out.println(Thread.currentThread() + String.valueOf(finalI) + " is running...");
                    TimeUnit.SECONDS.sleep(1);
                    return Thread.currentThread() + "-----" + String.valueOf(finalI);
            
                }
            }));*/
            System.out.println("start add res " + String.valueOf(finalI));
            Future<String> res = executorService.submit(new Callable<String>() {
                public String call() throws InterruptedException {
                    System.out.println(Thread.currentThread() + String.valueOf(finalI) + " is running...");
                    TimeUnit.SECONDS.sleep(1);
                    return Thread.currentThread() + "-----" + String.valueOf(finalI);

                }
            });
            System.out.println("end add res " + String.valueOf(finalI));
            ftList.add(res);
        }
        System.out.println("executor is shutdown :" + executorService.isShutdown());
        executorService.shutdown();
        LocalDateTime end01 = LocalDateTime.now();
        System.out.println("end01 time is : " + end01);
        ftList.forEach(e -> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }
        });
        LocalDateTime end02 = LocalDateTime.now();
        System.out.println("end02 time is : " + end02);
        System.out.println("using time : " + Duration.between(start, end02));

        // executorService.shutdown();
        System.out.println("executor isn shutdown :" + executorService.isShutdown());
    }
}
