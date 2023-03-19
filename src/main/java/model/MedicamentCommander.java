package model;

public class MedicamentCommander {
    private int id_med_comm;
    private int id_comm;
    private int id_med;
    private int qte_comm;

    public MedicamentCommander() {
    }

    public MedicamentCommander(int id_med_comm, int id_comm, int id_med, int qte_comm) {
        super();
        this.id_med_comm = id_med_comm;
        this.id_comm = id_comm;
        this.id_med = id_med;
        this.qte_comm = qte_comm;
    }

    public MedicamentCommander(int id_comm, int id_med, int qte_comm) {
        super();
        this.id_comm = id_comm;
        this.id_med = id_med;
        this.qte_comm = qte_comm;
    }

    public int getId_med_comm() {
        return id_med_comm;
    }

    public void setId_med_comm(int id_med_comm) {
        this.id_med_comm = id_med_comm;
    }

    public int getId_comm() {
        return id_comm;
    }

    public void setId_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    public int getQte_comm() {
        return qte_comm;
    }

    public void setQte_comm(int qte_comm) {
        this.qte_comm = qte_comm;
    }

    @Override
    public String toString() {
        return "MedicamentCommander [id_med_comm=" + id_med_comm + ", id_comm=" + id_comm + ", id_med=" + id_med
                + ", qte_comm=" + qte_comm + "]";
    }


}
