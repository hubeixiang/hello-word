package com.sven.mvel2;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sven on 2017/1/12.
 */
public class MvelExpressionUtil {
    /**
     * 根据四则运算字符串提取出变量
     */
    public static Set<String> getVarsListFromExpression(String expression) {
        Set<String> vars = new HashSet<String>();
        Matcher matcher = expPattern.matcher(expression);

        while (matcher.find()) {
            String value = matcher.group();
            String column = getColumnFromExpression(value);
            vars.add(column);
        }

        return vars;
    }

    /**
     * 根据四则运算字符串提取出格式化之后的表达式。
     */
    public static String getFormatedExpression(String expression) {
        Matcher matcher = expPattern.matcher(expression);
        String newExp = expression;

        while (matcher.find()) {
            String value = matcher.group();
            int index = value.indexOf(splitChar);
            String newValue = value;

            if (index != -1) {
                newValue = value.substring(0, index);
            }

            newExp = newExp.replace("[" + value + "]", newValue);
        }

        return newExp;
    }

    /**
     * 解析表达式，取出列明和汇聚方式。
     */
    public static String getColumnFromExpression(String expression) {
        String[] tmp = expression.trim().split(splitChar);
        String colName = tmp[0];
        return colName;
    }

    private static final String splitChar = "#";
    private static final String regex = "(?<=\\[).*?(?=\\])";
    private static final Pattern expPattern = Pattern.compile(regex);
}
