package com.sven.springboot.db.service.impl;

import com.sven.springboot.db.dao.OracleTestDemoRepository;
import com.sven.springboot.db.entity.OracleTestDemo;
import com.sven.springboot.db.service.IRedisOracleTestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by 123 on 2016/8/30.
 */

@Service
public class RedisOracleTestDemoServiceImpl implements IRedisOracleTestDemoService {

    @Autowired
    OracleTestDemoRepository oracleTestDemoRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void save(OracleTestDemo demo) {
        oracleTestDemoRepository.save(demo);
    }

    @Cacheable(value = "oracleTestDemo", key = "#id")
    @Override
    public OracleTestDemo findById(long id) {
        System.err.println("RedisOracleTestDemoServiceImpl.findById()=========从数据库中进行获取的....id=" + id);
        OracleTestDemo demo = oracleTestDemoRepository.findOne(id);
        return demo;
    }

    @CacheEvict(value = "oracleTestDemo", key = "#id")
    @Override
    public void deleteFromCache(long id) {
        System.out.println("RedisOracleTestDemoServiceImpl.delete().从缓存中删除.");
    }

    @Override
    public void test() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1=" + Math.random());
        System.out.println("RedisOracleTestDemoServiceImpl.test():" + valueOperations.get("mykey4"));
    }
}
