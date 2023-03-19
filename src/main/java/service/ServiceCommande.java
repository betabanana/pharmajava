package service;

import dao.InstanceMedicamentDAO;
import dao.MedicamentCommanderDAO;
import dao.MedicamentDAO;
import model.InstanceMedicament;
import model.Medicament;
import model.MedicamentCommander;

import java.util.List;

public class ServiceCommande {


    public void ajouterMedPanier(int id_med, int id_comm, int qte_comm ){
        qte_comm = 1;
        List<Medicament> meds;
        MedicamentDAO medDAO =new  MedicamentDAO();
        meds =  ServiceMedicament.listMedicaments();
        InstanceMedicament instMed ;
        InstanceMedicamentDAO instMedDAO = new InstanceMedicamentDAO();
        for (Medicament med : meds) {
            if(med.getId_med() == id_med){

            int qte = Math.abs(med.getQte_med()-1);

            if(qte>=0){
                instMed = instMedDAO.selecterInstanceMedParMedId(med.getId_med());
                instMedDAO.commanderInstance(instMed.getId_instance_med());
                MedicamentCommander medComm ;
                MedicamentCommanderDAO medCommDAO = new MedicamentCommanderDAO();

                medCommDAO.insererMedComm(id_comm, qte_comm, instMed.getId_instance_med());

            }
            }
        }

    }

}
