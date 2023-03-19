package service;

import dao.UtilisateurDAO;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;

import java.sql.SQLException;


public class authService {

    public static boolean authentifierUtil(String email_util, String pwd_util) throws SQLException {

        UtilisateurDAO utilDAO = new UtilisateurDAO();
        Utilisateur util = utilDAO.obtenirUtilParEmail(email_util, pwd_util);

        if (util == null) {

            return false;
        }

        return pwd_util.equals(util.getPwd_util());
    }

    public static Utilisateur obtenirUtilisateur(HttpSession session) throws SQLException {
        Utilisateur util = null;
        if (session != null) {
            util = (Utilisateur) session.getAttribute("util");
            if (!authentifierUtil(util.getEmail_util(), util.getPwd_util())) {
                util = null;
            }
        }
        return util;
    }
}
