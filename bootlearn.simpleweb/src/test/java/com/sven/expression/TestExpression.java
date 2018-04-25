package com.sven.expression;

import com.sven.mvel2.MvelExpressionContext;
import com.sven.mvel2.MvelExpressionUtil;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sven on 2017/1/12.
 */
public class TestExpression {

    @Test
    public void test() {
        String function = "'Hello World!'";
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(function);
        String str1 = expression.getValue(String.class);
        System.out.println(str1);
    }


    @Test
    public void test1() {
        String function = "'Hello World!'";
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(function);
        String str1 = expression.getValue(String.class);
        System.out.println(str1);
    }

    @Test
    public void test2() {
//        String formal = "1+2-3*4/2.5";
//        String formal = "[a]+[b]-rate(([c]*[d]),[b],1,2,3,4)";
//        String formal = "[a]+[b]-[c]*[d]/[e]";
        String formal = "[a]+[b]-[c]*[d]/[b] + 100";
//        String formal = "[a]+[b]";
//        String formal = "rate([d],[b])";
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("a", 1);
        dataMap.put("b", null);
        dataMap.put("c", 3);
        dataMap.put("d", 4);
        dataMap.put("e", "2.5");
        System.out.println(formal);
        System.out.println(MvelExpressionUtil.getVarsListFromExpression(formal));
        MvelExpressionContext mvelExpressionContext = MvelExpressionContext.getInstance();
        Object o = mvelExpressionContext.execute(formal, dataMap);
        System.out.println(o);


    }
}
