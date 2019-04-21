package com.example.demo02.service;

import org.junit.Test;


public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    
    @Test
    public void testThreadLocal() {
        threadLocal.set("test threadLocal str");

        System.out.println("this is main thread , threadLocal is " + threadLocal.get());

        testFuncThreadLocal();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is thread01 " + Thread.currentThread());
                System.out.println("threadLocal str 001 is" + threadLocal.get());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is thread02 " + Thread.currentThread());
                System.out.println("threadLocal str 002 is" + threadLocal.get());
            }
        });
        thread1.start();
        thread2.start();
    }

    private void testFuncThreadLocal() {
        System.out.println("this is testFuncThreadLocal, threadLocal is " + threadLocal.get());
    }
}
