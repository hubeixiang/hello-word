package com.sven.mvel2;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledExpression;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sven on 2017/1/12.
 */
public class MvelExpressionContext {

    private static MvelExpressionContext instance = null;
    private ParserContext pc = new ParserContext();

    private HashMap<String, MvelExpression> expCache = new HashMap<String, MvelExpression>();


    /*
     *
     * 构造方法,进行资源初始化。通过对MathFunction类的反射处理，加载所用的方法并添加到MVEL中
     *
     */
    private MvelExpressionContext() {
        try {

            Method[] methods = MathFunction.class.getDeclaredMethods();

            for (Method m : methods) {

                pc.addImport(m.getName(), m);
            }

        } catch (SecurityException e) {
            throw new RuntimeException("加载函数库失败", e);
        }
    }

    /**
     * 取得唯一的实例对象
     *
     * @return 实例对象
     */
    public synchronized static MvelExpressionContext getInstance() {
        if (instance == null) {
            instance = new MvelExpressionContext();
        }
        return instance;
    }

    /**
     * 执行运算处理
     *
     * @param exp  运算表达式
     * @param vars 运算变量Map集合
     * @return 运算结果
     */
    public Object execute(String exp, Map<String, Object> vars) {
        //从缓存中获取
        MvelExpression expression = getExpression(exp);
        CompiledExpression compiledExpression =expression.getCompiledExpression();
        System.out.println(compiledExpression.toString());
        Object result =
                MVEL.executeExpression(compiledExpression, pc, vars);
        //MVEL.executeExpression(expression.getCompiledExpression(), pc, vars);
        //log.debug(exp + " = " + result);
        return result;
    }

    /**
     * 从缓存中获取Expression，如果缓存中没有，就新建一个Expression并缓存。
     *
     * @param exp
     * @return
     */
    public MvelExpression getExpression(String exp) {
        exp = exp == null ? "" : exp;

        MvelExpression expression = expCache.get(exp);

        if (expression == null) {
            expression = new MvelExpression(exp, pc);
            expCache.put(exp, expression);
        }

        return expression;
    }

}
