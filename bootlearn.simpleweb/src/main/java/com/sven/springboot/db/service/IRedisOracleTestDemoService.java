package com.sven.springboot.db.service;

import com.sven.springboot.db.entity.OracleTestDemo;

/**
 * Created by 123 on 2016/8/30.
 */
public interface IRedisOracleTestDemoService {

    public void save(OracleTestDemo demo);

    public OracleTestDemo findById(long id);

    public void deleteFromCache(long id);

    public void test();
}
