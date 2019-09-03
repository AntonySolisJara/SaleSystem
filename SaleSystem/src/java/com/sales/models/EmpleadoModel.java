package com.sales.models;

/**
 *
 * @author Antony
 */
public class EmpleadoModel {
    int id;
    String ced, nom, tel, cor, user, cont, est;

    public EmpleadoModel() {
    }

    public EmpleadoModel(int id, String ced, String nom, String tel, String cor, String user, String cont, String est) {
        this.id = id;
        this.ced = ced;
        this.nom = nom;
        this.tel = tel;
        this.cor = cor;
        this.user = user;
        this.cont = cont;
        this.est = est;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }
    
}
