package web;

import dao.CommandeDAO;
import dao.MedicamentCommanderDAO;
import dao.MedicamentDAO;
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
import service.ServiceCommande;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class ServletPanier extends HttpServlet {


    public ServletPanier() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd;
        List<MedicamentCommander> medComm  ;
        MedicamentCommanderDAO medComDAO = new MedicamentCommanderDAO();
        CommandeDAO  commDAO = new CommandeDAO();
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

        MedicamentDAO medDAO  = new MedicamentDAO();
        medComDAO =new MedicamentCommanderDAO();
        List<MedicamentCommander> medCom = medComDAO.listMedCommParComm(id_comm);
        List<Medicament> lm = new ArrayList<>();

        for (MedicamentCommander mc : medCom) {

            int id_med=  mc.getId_med();
            Medicament med = medDAO.selecterMedicament(id_med) ;
            lm.add(med);
        }


        request.setAttribute("lm", lm);
        request.setAttribute("id_comm", id_comm);
        rd = request.getRequestDispatcher("/WEB-INF/views/panier.jsp");
        rd.forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	Utilisateur util =  (Utilisateur) session.getAttribute("user");
        CommandeDAO  commDAO = new CommandeDAO();
        Commande comm ; //commande de type panier
        
        int id_med = Integer.parseInt(request.getParameter("id_med"));
        MedicamentDAO medDAO = new MedicamentDAO();
        Medicament med = medDAO.selecterMedicament(id_med);
        
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
        ServiceCommande sc = new ServiceCommande();
        sc.ajouterMedPanier(id_med, id_comm, 1);

        //MedicamentCommander medComm = new MedicamentCommander(id_comm,id_med , 1) ;

        
    }

}
