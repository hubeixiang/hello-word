package com.sven.aop.spring.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sven on 2017/5/19.
 * 目标对象,实现目标接口
 */
public class PersonDaoImpl implements PersonDao {
    private Map<Long, PersonN> map = new HashMap<Long, PersonN>();

    public PersonDaoImpl() {
        PersonN person1 = new PersonN();
        person1.setPid(1L);
        person1.setPname("person1");
        map.put(person1.getPid(), person1);
        PersonN person2 = new PersonN();
        person2.setPid(2L);
        person2.setPname("person2");
        map.put(person2.getPid(), person2);
    }

    @Override
    public void deletePerson(PersonN person) {
        if (map.containsKey(person.getPid())) {
            map.remove(person.getPid());
            System.out.println("delete person success pid=" + person.getPid());
        } else {
            System.out.println("delete person failure.not exists pid=" + person.getPid());
        }
    }

    @Override
    public List<PersonN> getPerson() throws Exception {
        List<PersonN> personList = new ArrayList<PersonN>();
        for (PersonN person : map.values()) {
            personList.add(person);
        }
        System.out.println("get person:" + personList.size());
        return personList;
    }

    @Override
    public void savePerson(PersonN person) {
        if (map.containsKey(person.getPid())) {
            map.put(person.getPid(), person);
            System.out.println("save person. update pid=" + person.getPid());
        } else {
            map.put(person.getPid(), person);
            System.out.println("save person. add pid=" + person.getPid());
        }
    }

    @Override
    public void updatePerson(PersonN person) {
        if (map.containsKey(person.getPid())) {
            map.put(person.getPid(), person);
            System.out.println("update person. update pid=" + person.getPid());
        } else {
            map.put(person.getPid(), person);
            System.out.println("update person. add pid=" + person.getPid());
        }
    }
}
