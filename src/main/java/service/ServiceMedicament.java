package service;

import dao.InstanceMedicamentDAO;
import dao.MedicamentDAO;
import model.InstanceMedicament;
import model.Medicament;

import java.util.Iterator;
import java.util.List;

 public class ServiceMedicament {
    private int id_med;

// pour afficer tous les medicament activés ,  non commander et qte > 1
    public static List<Medicament> listMedicaments(){
        MedicamentDAO medDAO = new MedicamentDAO();
        List<Medicament> meds = medDAO.selecterTousMedicamentActiver();
        Iterator<Medicament> it = meds.iterator();

    //pour tester si le medicament a des instance si non supprimer le medicament de la list
        while (it.hasNext()) {
        Medicament currentMed = it.next();
        int id_med =  currentMed.getId_med();
        List <InstanceMedicament> instMed ;
        InstanceMedicamentDAO instMedDAO = new InstanceMedicamentDAO();
        instMed = instMedDAO.listInstanceParMedId(id_med);
        int qte_med = 0;
        Iterator<InstanceMedicament> its = instMed.iterator();
        while (its.hasNext()){
            qte_med += its.next().getQte_stock_med();
        }

        if(qte_med == 0){
            it.remove();
        }else {
            currentMed.setQte_med(qte_med);
        }
    }
        return meds;
    }
     public static List<Medicament> listMedParMotCle(String motCle){
         MedicamentDAO medDAO = new MedicamentDAO();
         List<Medicament> meds = medDAO.selecterMedParMotCle(motCle);
         Iterator<Medicament> it = meds.iterator();

         //pour tester si le medicament a des instance si non supprimer le medicament de la list
         while (it.hasNext()) {
             Medicament currentMed = it.next();
             int id_med =  currentMed.getId_med();
             List <InstanceMedicament> instMed ;
             InstanceMedicamentDAO instMedDAO = new InstanceMedicamentDAO();
             instMed = instMedDAO.listInstanceParMedId(id_med);
             int qte_med = 0;
             Iterator<InstanceMedicament> its = instMed.iterator();
             while (its.hasNext()){
                 qte_med += its.next().getQte_stock_med();
             }

             if(qte_med == 0){
                 it.remove();
             }else {
                 currentMed.setQte_med(qte_med);
             }
         }
         return meds;
     }

}
