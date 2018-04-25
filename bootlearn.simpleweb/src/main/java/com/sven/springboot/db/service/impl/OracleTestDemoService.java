package com.sven.springboot.db.service.impl;

import com.sven.springboot.db.dao.OracleTestDemoRepository;
import com.sven.springboot.db.entity.OracleTestDemo;
import com.sven.springboot.db.service.IOracleTestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 123 on 2016/8/13.
 */
@Service
public class OracleTestDemoService implements IOracleTestDemoService {
    @Autowired
    private OracleTestDemoRepository oracleTestDemoRepository;

    @Transactional
    public void save(OracleTestDemo demo) {
        oracleTestDemoRepository.save(demo);
    }
}
