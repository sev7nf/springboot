package com.example.demo02.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Alexchs
 * @Description:
 * @Date: created in 23:16 2018-12-02
 * @ModifiedBy:
 * @URL:
 */
@Mapper
public interface DBMapper {
    List<Object> queryInfo();
}
