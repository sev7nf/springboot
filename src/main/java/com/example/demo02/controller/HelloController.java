package com.example.demo02.controller;


import com.example.demo02.controller.VO.DemoEntity;
import com.example.demo02.service.DBImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/demo")
public class HelloController {
    // 打日志
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    DBImpl db;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public @ResponseBody
    DemoEntity hello() {
        DemoEntity demo = new DemoEntity();
        demo.setDataId("Alexchs_01");
        demo.setAge(25);
        demo.setName("Alexchs");
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        logger.warn("这是warn信息");
        logger.error("这是error信息");
        return demo;
    }

    @GetMapping(value = "/dbInfo")
    public List<Object> dbInfo() {
        List<Object> objectsRes = db.queryInfo();

        return objectsRes;
    }
}
