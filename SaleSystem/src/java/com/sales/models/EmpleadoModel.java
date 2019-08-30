package com.sales.models;

/**
 *
 * @author Antony
 */
public class EmpleadoModel {
    int id;
    String ced, nom, tel, est, user;

    public EmpleadoModel() {
    }

    public EmpleadoModel(int id, String ced, String nom, String tel, String est, String user) {
        this.id = id;
        this.ced = ced;
        this.nom = nom;
        this.tel = tel;
        this.est = est;
        this.user = user;
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

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
