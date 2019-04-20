package com.example.demo02.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Alexchs
 * @Description:
 * @Date: created in 23:43 2019-01-11
 * @ModifiedBy:
 * @URL:
 */
@Component
@Slf4j
public class ScheduleImpl {
//    @Scheduled(cron="0/10 * *  * * ? ")
//    @Async
    public void scheduleTest() {
      log.debug("Schedule Start");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Schedule end"); 
    }
}
