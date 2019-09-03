package com.sales.models;

/**
 *
 * @author Antony
 */
public class ClienteModel {
    int id;
    String ced, nom, tel, cor, dir, est;

    public ClienteModel() {
    }

    public ClienteModel(int id, String ced, String nom, String tel, String cor, String dir, String est) {
        this.id = id;
        this.ced = ced;
        this.nom = nom;
        this.tel = tel;
        this.cor = cor;
        this.dir = dir;
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

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }
    
}
