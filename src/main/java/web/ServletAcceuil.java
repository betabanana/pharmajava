package web;

import dao.CommandeDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Commande;
import model.Medicament;
import model.MedicamentCommander;
import model.Utilisateur;
import service.ServiceMedicament;
import tst.MedicamentCommanderDAO;

import java.io.IOException;
import java.sql.Date;
import java.util.List;



public class ServletAcceuil extends HttpServlet {

    public ServletAcceuil() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd;
        List<Medicament> meds = ServiceMedicament.listMedicaments();
        request.setAttribute("meds", meds);


        List<MedicamentCommander> medComm  ;
        dao.MedicamentCommanderDAO medComDAO = new dao.MedicamentCommanderDAO();
        CommandeDAO commDAO = new CommandeDAO();
        Commande comm ; //commande de type panier
        HttpSession session = request.getSession();
        Utilisateur util =  (Utilisateur) session.getAttribute("user");

        if(util != null) {
            // tester si l'utilisateur a une commande(panier)
            if (commDAO.selecterCommandeParStatus(1) == null) {
                int status_comm = 1;
                int id_util = util.getId_util();
                Date date_comm = new Date(System.currentTimeMillis());
                Commande new_comm = new Commande(status_comm, id_util, date_comm);
                commDAO.insererCommande(new_comm);


            }
            comm = commDAO.selecterCommandeParStatus(1);


            int id_comm = comm.getId_comm();

            MedicamentCommanderDAO medCommDAO = new MedicamentCommanderDAO();

            int qteComm = medCommDAO.Qte_com(id_comm);
            request.setAttribute("qteComm", qteComm);
        }
        rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher rd;


        List<Medicament> meds = ServiceMedicament.listMedicaments();
        request.setAttribute("meds", meds);


        List<MedicamentCommander> medComm  ;
        dao.MedicamentCommanderDAO medComDAO = new dao.MedicamentCommanderDAO();
        CommandeDAO commDAO = new CommandeDAO();
        Commande comm ; //commande de type panier
        HttpSession session = request.getSession();
        Utilisateur util =  (Utilisateur) session.getAttribute("user");

        // tester si l'utilisateur a une commande(panier)
        if(commDAO.selecterCommandeParStatus(1) == null) {
            int status_comm = 1;
            int id_util = util.getId_util();
            Date date_comm = new Date(System.currentTimeMillis());
            Commande new_comm = new Commande(status_comm, id_util, date_comm);
            commDAO.insererCommande(new_comm);


        }
        comm = commDAO.selecterCommandeParStatus(1);


        int id_comm = comm.getId_comm();

        MedicamentCommanderDAO medCommDAO = new MedicamentCommanderDAO();

        int qteComm = medCommDAO.Qte_com(id_comm);
        request.setAttribute("qteComm",qteComm);


        String motCle = request.getParameter("motCle");

        List<Medicament> medss = ServiceMedicament.listMedParMotCle(motCle);
        request.setAttribute("meds", medss);
        rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        rd.forward(request, response);
    }

}
