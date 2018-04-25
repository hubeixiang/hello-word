package com.sven.springboot.db.dao;

import com.sven.springboot.db.entity.OracleTestDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 123 on 2016/8/13.
 */
@Repository
public interface OracleTestDemoRepository extends CrudRepository<OracleTestDemo, Long> {
}
