package com.example.demo02.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo02.controller.VO.DemoEntity;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author: Alexchs
 * @Description:
 * @Date: created in 0:01 2018-12-19
 * @ModifiedBy:
 * @URL:
 */
public class DBImplTest {

    @Test
    public void stringSplitTest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("当前循环次数：" + i);
        }
        stopWatch.stop();
        System.out.println("耗时：" + stopWatch.getTime());
    }

    @Test
    public void lambdaTest() {
        Map<String, Object> res = new HashMap<>();
        List<DemoEntity> list = new ArrayList<>();
        list.add(new DemoEntity("test01"));
        list.add(new DemoEntity("test02"));
        list.add(new DemoEntity("test03"));
//        res.put("", list);
        res.put("", JSON.toJSONString("[]"));
        List<DemoEntity> value;
        for (String key : res.keySet()) {
            String resValue = res.get(key).toString();
            value = JSON.parseArray(resValue, DemoEntity.class);
        }
        System.out.println("-------end------");
    }

}