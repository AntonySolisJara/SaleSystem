package com.sales.models;

/**
 *
 * @author Antony
 */
public class ProductoModel {
    int id, stk;
    String descr, est;
    double prec;

    public ProductoModel() {
    }

    public ProductoModel(int id, String descr, double prec, int stk, String est) {
        this.id = id;
        this.descr = descr;
        this.prec = prec;
        this.stk = stk;
        this.est = est;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStk() {
        return stk;
    }

    public void setStk(int stk) {
        this.stk = stk;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }
    
}
