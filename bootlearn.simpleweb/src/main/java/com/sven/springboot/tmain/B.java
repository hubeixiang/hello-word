package com.sven.springboot.tmain;

/**
 * Created by 123 on 2016/10/12.
 */
public class B extends A {
    private String b = "b";
    private String k = "kb";
    protected String v = "vb";
    public String p = "pb";

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
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
