package com.example.demo02.service;

import com.example.demo02.dao.DBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Alexchs
 * @Description:
 * @Date: created in 23:15 2018-12-02
 * @ModifiedBy:
 * @URL:
 */
@Service
public class DBImpl implements DB {
    @Resource
    DBMapper dbMapper;

    @Override
    public List<Object> queryInfo() {
        return dbMapper.queryInfo();
    }
}
