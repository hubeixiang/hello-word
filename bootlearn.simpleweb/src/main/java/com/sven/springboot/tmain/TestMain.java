package com.sven.springboot.tmain;

import java.math.BigDecimal;

/**
 * Created by 123 on 2016/10/12.
 */
public class TestMain {
    public static void main(String[] args) {
        float y = 7F;
        String value = ".2";
        String regex = ".*[a-z,A-Z].*";
        if (value.matches(regex)) {
            System.out.println("match ...");
        } else {
            System.out.println("not match ...");
        }
        Double d = Double.valueOf(value.trim());
        System.out.println(d);
        String[] cells = new String[]{"", null, ".", "1.0", "9.", "1..", "2.1", "0.1", ".2", "7F"};
        for (String cell : cells) {
            System.out.println("[" + cell + "]=>[" + isNum(cell) + "]");
        }

        A a = new A();
        B b = new B();
        C c = new C();

        printA(a);
        printB(b);
        printC(c);
        printA(c);
        printB(c);
        c.setK("-ck");
        c.setV("-cv");
        printC(c);
        printA(c);
        printB(c);
        B b2 = (B) c;
        printA(b2);
        printB(b2);
        System.out.println("----end----");
        String xx = "第一行\n第二行";
        System.out.println(xx);
        System.out.println("----over----");
    }

    public static void printA(A a) {
        System.out.println(String.format("-----------------A[%s]------------------", a.getA()));
        System.out.println(String.format("--k[%s]", a.getK()));
        System.out.println(String.format("--v[%s]", a.getV()));
        System.out.println(String.format("--p[%s]", a.getP()));
    }

    public static void printB(B a) {
        System.out.println(String.format("-----------------B[%s]------------------", a.getB()));
        System.out.println(String.format("--k[%s]", a.getK()));
        System.out.println(String.format("--v[%s]", a.getV()));
        System.out.println(String.format("--p[%s]", a.getP()));
    }

    public static void printC(C a) {
        System.out.println(String.format("-----------------C[%s]------------------", a.getC()));
        System.out.println(String.format("--k[%s]", a.getK()));
        System.out.println(String.format("--v[%s]", a.getV()));
        System.out.println(String.format("--p[%s]", a.getP()));
    }

    public static boolean isNum(String str) {

        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
