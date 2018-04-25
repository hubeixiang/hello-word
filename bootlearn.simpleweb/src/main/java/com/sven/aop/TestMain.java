package com.sven.aop;


import com.sven.aop.calc.Calculator;
import com.sven.aop.calc.impl.CalculatorImpl;
import com.sven.aop.handler.SomeHandler;

/**
 * Created by sven on 2016/12/26.
 */
public class TestMain {
    public static void main(String[] args) {
        CalculatorImpl calcImpl = new CalculatorImpl();

        SomeHandler someHandler = new SomeHandler(calcImpl);

        Calculator calculator = (Calculator) someHandler.getProxy();
        System.out.println("FInal Result :::" + calculator.calculate(20,2));



        //生成代理类的二进制码文件
        ProxyGeneratorUtils.writeProxyClassToHardDisk("F:/$Proxy11.class");
    }
}
