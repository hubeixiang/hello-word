package com.sven.springboot.gener;

import java.lang.reflect.ParameterizedType;

/**
 * Created by sven on 2017/1/18.
 */
public class T2 extends T1<Integer> {
    public static void main(String[] args) {
        T2 t = new T2();

        ColumnList orderColumns = new ColumnList();
        orderColumns.add("xxx");
        ParameterizedType parameterizedType = (ParameterizedType) orderColumns.getClass().getGenericSuperclass();
        Class<?> clazz = (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }
}
