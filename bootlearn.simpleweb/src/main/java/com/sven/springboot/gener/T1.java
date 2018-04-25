package com.sven.springboot.gener;

import java.lang.reflect.ParameterizedType;

/**
 * Created by sven on 2017/1/18.
 */
public class T1<T> {
    private Class classt;

    public T1() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.classt = (Class) type.getActualTypeArguments()[0];
        System.out.println(this.classt);
    }
}
