package model;

public class Ordonnance {
    private int id_ord;
    private String fichier_ord;
    private int id_comm;

    public Ordonnance() {
    }

    public Ordonnance(int id_ord, String fichier_ord, int id_comm) {
        super();
        this.id_ord = id_ord;
        this.fichier_ord = fichier_ord;
        this.id_comm = id_comm;
    }

    public int getId_ord() {
        return id_ord;
    }

    public void setId_ord(int id_ord) {
        this.id_ord = id_ord;
    }

    public String getFichier_ord() {
        return fichier_ord;
    }

    public void setFichier_ord(String fichier_ord) {
        this.fichier_ord = fichier_ord;
    }

    public int getId_comm() {
        return id_comm;
    }

    public void setId_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    @Override
    public String toString() {
        return "Ordonnace [id_ord=" + id_ord + ", fichier_ord=" + fichier_ord + ", id_comm=" + id_comm + "]";
    }


}
