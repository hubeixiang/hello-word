package com.sven.mvel2;

import oracle.sql.TIMESTAMP;

/**
 * Created by sven on 2017/1/12.
 */
public class Tool {
    public static String getString(Object value) {
        if(value instanceof TIMESTAMP) {
            return ((TIMESTAMP)value).stringValue();
        } else {
            return value == null ? "" : value.toString();
        }
    }

    public static Double getDouble(Object value) {
        if(value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        } else if (value instanceof String) {
            return Double.valueOf((String)value);
        } else {
            throw new RuntimeException("输入错误的类型,无法转换为double");
        }
    }
}
