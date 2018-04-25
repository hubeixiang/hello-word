package com.sven.aop.spring.xml;

import java.util.List;

/**
 * Created by sven on 2017/5/19.
 * 目标对象和代理对象都需要实现的接口
 */
public interface PersonDao {
    void deletePerson(PersonN person);

    List<PersonN> getPerson() throws Exception;

    void savePerson(PersonN person);

    void updatePerson(PersonN person);
}
