package com.sven.mvel2;

import java.math.BigDecimal;

/**
 * Created by sven on 2017/1/12.
 */
public class MathFunction {
    private static final BigDecimal ZERO = new BigDecimal("0");

    /**
     * 取得率值
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 计算后的率值
     */
    public static Object rate(Object dividend, Object divisor) {
        return rate(dividend, divisor, null, 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 取得率值
     *
     * @param dividend       被除数
     * @param divisor        除数
     * @param exceptionValue 当除数为0时，结果返回该参数
     * @return 计算后的率值
     */
    public static Object rate(Object dividend, Object divisor, Object exceptionValue) {
        return rate(dividend, divisor, exceptionValue, 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 取得率值
     *
     * @param dividend       被除数
     * @param divisor        除数
     * @param exceptionValue 当除数为0时，结果返回该参数
     * @param scale          保留的商的标度
     * @param roundingMode   舍入模式
     * @return 计算后的率值
     * @author Boyuan.Bao
     */
    public static Object rate(Object dividend,
                              Object divisor,
                              Object exceptionValue,
                              Integer scale,
                              int roundingMode) {

        if (dividend == null || divisor == null) {
            return null;
        }

        BigDecimal bigDividend = new BigDecimal(Tool.getString(dividend));
        BigDecimal bigDivisor = new BigDecimal(Tool.getString(divisor));

        if (ZERO.compareTo(bigDivisor) == 0) {
            return exceptionValue;
        }

        return Tool.getDouble(bigDividend.divide(bigDivisor, scale, roundingMode));
    }
}
