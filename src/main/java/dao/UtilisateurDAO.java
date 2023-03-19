package dao;

import model.Utilisateur;

import java.sql.*;

public class UtilisateurDAO {

    private static final String INSERT_USERS = "INSERT INTO utilisateurs (" + "nom_util ," + "prenom_util ,"
            + "email_util ," + "pwd_util ," + "date_naiss_util ," + "adresse_util," + "tele_util "
            + ") VALUES  (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select * from utilisateurs where id_util =?";
    private static final String SELECT_USER_BY_EMAIL = "select * from utilisateurs where email_util =? AND pwd_util=?";
    private static Connection con ;
    private ResultSet rs;
    private PreparedStatement pst;
    public UtilisateurDAO() {
       con = SingletonConnection.getConnection();
    }

    public boolean insererUtilisateur(Utilisateur util) {
        boolean ok = false;
        try {
             pst = con.prepareStatement(INSERT_USERS);

            pst.setString(1, util.getNom_util());
            pst.setString(2, util.getPrenom_util());
            pst.setString(3, util.getEmail_util());
            pst.setString(4, util.getPwd_util());
            pst.setDate(5, util.getDate_naiss_util());
            pst.setString(6, util.getAdresse_util());
            pst.setString(7, util.getTele_util());

            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            printSQLException(e);

        }
        return ok;
    }

    public Utilisateur selectUser(int id_util) {
        Utilisateur util = null;

        try {pst = con.prepareStatement(SELECT_USER_BY_ID) ;
            pst.setInt(1, id_util);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String nom_util = rs.getString("nom_util");
                String prenom_util = rs.getString("prenom_util");
                Date date_naiss_util = rs.getDate("date_naiss_util");
                String adresse_util = rs.getString("adresse_util");
                String tele_util = rs.getString("tele_util");
                String email_util = rs.getString("email_util");
                String pwd_util = rs.getString("pwd_util");

                util = new Utilisateur(id_util, nom_util, prenom_util, date_naiss_util, adresse_util, tele_util,
                        email_util, pwd_util);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return util;
    }

    public Utilisateur obtenirUtilParEmail(String email_util, String pwd_util) {

        Utilisateur util = null;
        try { pst = con.prepareStatement(SELECT_USER_BY_EMAIL);
            pst.setString(1, email_util);
            pst.setString(2, pwd_util);
            rs = pst.executeQuery();
            if (rs.next()) {
                util = new Utilisateur();
                int id_util = rs.getInt("id_util");
                String nom_util = rs.getString("nom_util");
                String prenom_util = rs.getString("prenom_util");
                Date date_naiss_util = rs.getDate("date_naiss_util");
                String adresse_util = rs.getString("adresse_util");
                String tele_util = rs.getString("tele_util");

                util = new Utilisateur(id_util, nom_util, prenom_util, date_naiss_util, adresse_util, tele_util,
                        email_util, pwd_util);
                return util;
            } else {
                return null;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return util;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
