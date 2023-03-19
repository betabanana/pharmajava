package model;

import java.sql.Date;

public class InstanceMedicament {
    private int id_instance_med;
    private Double prix_med;
    private Date date_exp_med;
    private Date date_prod_med;
    private int qte_stock_med;
    private int id_med;

    public InstanceMedicament() {
    }

    public InstanceMedicament(int id_instance_med, Double prix_med, Date date_exp_med, Date date_prod_med,
                              int qte_stock_med, int id_med) {
        super();
        this.id_instance_med = id_instance_med;
        this.prix_med = prix_med;
        this.date_exp_med = date_exp_med;
        this.date_prod_med = date_prod_med;
        this.qte_stock_med = qte_stock_med;
        this.id_med = id_med;
    }

    public InstanceMedicament(Double prix_med, Date date_exp_med, Date date_prod_med, int qte_stock_med, int id_med) {
        super();
        this.prix_med = prix_med;
        this.date_exp_med = date_exp_med;
        this.date_prod_med = date_prod_med;
        this.qte_stock_med = qte_stock_med;
        this.id_med = id_med;
    }

    public InstanceMedicament(int id_instance_med, Date date_exp_med, Date date_prod_med, int qte_stock_med, int id_med) {
        this.id_instance_med = id_instance_med;
        this.date_exp_med = date_exp_med;
        this.date_prod_med = date_prod_med;
        this.qte_stock_med = qte_stock_med;
        this.id_med = id_med;
    }

    public int getId_instance_med() {
        return id_instance_med;
    }

    public void setId_instance_med(int id_instance_med) {
        this.id_instance_med = id_instance_med;
    }

    public Double getPrix_med() {
        return prix_med;
    }

    public void setPrix_med(Double prix_med) {
        this.prix_med = prix_med;
    }

    public Date getDate_exp_med() {
        return date_exp_med;
    }

    public void setDate_exp_med(Date date_exp_med) {
        this.date_exp_med = date_exp_med;
    }

    public Date getDate_prod_med() {
        return date_prod_med;
    }

    public void setDate_prod_med(Date date_prod_med) {
        this.date_prod_med = date_prod_med;
    }

    public int getQte_stock_med() {
        return qte_stock_med;
    }

    public void setQte_stock_med(int qte_stock_med) {
        this.qte_stock_med = qte_stock_med;
    }

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    @Override
    public String toString() {
        return "InstanceMedicament [id_instance_med=" + id_instance_med + ", prix_med=" + prix_med + ", date_exp_med="
                + date_exp_med + ", date_prod_med=" + date_prod_med + ", qte_stock_med=" + qte_stock_med + ", id_med="
                + id_med + "]";
    }


}
