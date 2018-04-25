package com.sven.aop.calc.impl;

import com.sven.aop.calc.Calculator;

/**
 * Created by sven on 2016/12/26.
 */
public class CalculatorImpl implements Calculator{
    @Override
    public int calculate(int a, int b) {
        return a/b;
    }
}
