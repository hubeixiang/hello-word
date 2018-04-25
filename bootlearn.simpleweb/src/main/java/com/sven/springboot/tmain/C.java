package com.sven.springboot.tmain;

/**
 * Created by 123 on 2016/10/12.
 */
public class C extends B {
    private String c = "c";
    private String k = "kc";
    protected String v = "vc";
    public String p = "pc";

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String getK() {
        return k;
    }

    @Override
    public void setK(String k) {
        this.k = k;
    }

    @Override
    public String getV() {
        return v;
    }

    @Override
    public void setV(String v) {
        this.v = v;
    }

    @Override
    public String getP() {
        return p;
    }

    @Override
    public void setP(String p) {
        this.p = p;
    }
}
