package com.sven.aop.spring.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sven on 2017/5/19.
 */
public class AOPXMLTest {
    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-xml.xml");
        PersonDao personDao = (PersonDao) context.getBean("personDao");
        System.out.println("=====================================================1");
        personDao.getPerson();

        PersonN n = new PersonN();
        n.setPid(3L);
        n.setPname("3name");
        System.out.println("=====================================================2");
        personDao.savePerson(n);
    }
}
