package model;

import java.sql.Date;

public class Utilisateur {

    private int id_util;
    private String nom_util;
    private String prenom_util;
    private Date date_naiss_util;
    private String adresse_util;
    private String tele_util;
    private String email_util;
    private String pwd_util;


    public Utilisateur() {
    }


    public Utilisateur(int id_util, String nom_util, String prenom_util, Date date_naiss_util, String adresse_util,
                       String tele_util, String email_util, String pwd_util) {
        super();
        this.id_util = id_util;
        this.nom_util = nom_util;
        this.prenom_util = prenom_util;
        this.date_naiss_util = date_naiss_util;
        this.adresse_util = adresse_util;
        this.tele_util = tele_util;
        this.email_util = email_util;
        this.pwd_util = pwd_util;
    }


    public Utilisateur(String nom_util, String prenom_util, Date date_naiss_util, String adresse_util, String tele_util,
                       String email_util, String pwd_util) {
        super();
        this.nom_util = nom_util;
        this.prenom_util = prenom_util;
        this.date_naiss_util = date_naiss_util;
        this.adresse_util = adresse_util;
        this.tele_util = tele_util;
        this.email_util = email_util;
        this.pwd_util = pwd_util;
    }


    public Utilisateur(String email_util, String pwd_util) {
        super();
        this.email_util = email_util;
        this.pwd_util = pwd_util;
    }


    public int getId_util() {
        return id_util;
    }


    public void setId_util(int id_util) {
        this.id_util = id_util;
    }


    public String getNom_util() {
        return nom_util;
    }


    public void setNom_util(String nom_util) {
        this.nom_util = nom_util;
    }


    public String getPrenom_util() {
        return prenom_util;
    }


    public void setPrenom_util(String prenom_util) {
        this.prenom_util = prenom_util;
    }


    public Date getDate_naiss_util() {
        return date_naiss_util;
    }


    public void setDate_naiss_util(Date date_naiss_util) {
        this.date_naiss_util = date_naiss_util;
    }


    public String getAdresse_util() {
        return adresse_util;
    }


    public void setAdresse_util(String adresse_util) {
        this.adresse_util = adresse_util;
    }


    public String getTele_util() {
        return tele_util;
    }


    public void setTele_util(String tele_util) {
        this.tele_util = tele_util;
    }


    public String getEmail_util() {
        return email_util;
    }


    public void setEmail_util(String email_util) {
        this.email_util = email_util;
    }


    public String getPwd_util() {
        return pwd_util;
    }


    public void setPwd_util(String pwd_util) {
        this.pwd_util = pwd_util;
    }


    @Override
    public String toString() {
        return "Utilisateur [id_util=" + id_util + ", nom_util=" + nom_util + ", prenom_util=" + prenom_util
                + ", date_naiss=" + date_naiss_util + ", adresse_util=" + adresse_util + ", tele_util=" + tele_util + "]";
    }


}
