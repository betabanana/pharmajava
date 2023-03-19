package web;

import dao.CommandeDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Utilisateur;

import java.io.IOException;

public class ServletPasserCommande extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur util =  (Utilisateur) session.getAttribute("user");

        if(util != null) {
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/views/commande-success.jsp" );
            dispatcher.forward( request, response );
        }
        else{

            response.sendRedirect("acceuil");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd;

        Double prix_comm = Double.parseDouble(request.getParameter("prix_comm"));
        int id_comm = Integer.parseInt(request.getParameter("id_comm"));

        CommandeDAO commDAO = new CommandeDAO();
        commDAO.modifierPrixComm(id_comm, prix_comm);
        commDAO.changerStatusCommande(id_comm, 2);

    }
}
