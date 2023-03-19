package web;

import dao.UtilisateurDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;

import java.io.IOException;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {


    public ServletLogin() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        RequestDispatcher rd;

        if (session.getAttribute("user") != null) {

            response.sendRedirect("acceuil");
        } else {

            rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            rd.forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email_util = request.getParameter("emailUtil");
        String pwd_util = request.getParameter("pwdUtil");

        HttpSession session = request.getSession();


        UtilisateurDAO utilDAO = new UtilisateurDAO();
        Utilisateur util = utilDAO.obtenirUtilParEmail(email_util, pwd_util);

        if (util != null) {


            session.setAttribute("user", util);
            response.sendRedirect("acceuil");
        } else {
            doGet(request, response);
        }


    }

}
