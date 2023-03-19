package dao;

import model.Ordonnance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdonnanceDAO {
    private static Connection con ;
    private ResultSet rs;
    private PreparedStatement pst;
    private static final String INSERT_ORDS = "INSERT INTO ordonnances ("
            + "fichier_ord,"
            + "id_comm "
            + ") VALUES  (?, ?);";

    private static final String SELECT_ORD_BY_ID = "select * from ordonance where id_ord =?";

    public OrdonnanceDAO() {

        con = SingletonConnection.getConnection();
    }


    public void insererOrdonnance(Ordonnance ord) {
        try{
            pst = con.prepareStatement(INSERT_ORDS);

            pst.setString(1, ord.getFichier_ord());
            pst.setInt(2, ord.getId_comm());

            pst.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Ordonnance selecterOrdonnance(int id_ord) {
        Ordonnance ord = null;

        try{
             pst = con.prepareStatement(SELECT_ORD_BY_ID);
            pst.setInt(1, id_ord);

             rs = pst.executeQuery();

            while (rs.next()) {
                String fichier_ord = rs.getString("fichier_ord");
                int id_comm = rs.getInt("id_comm");

                ord = new Ordonnance(id_ord, fichier_ord, id_comm);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ord;
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
    private static final String  SELECT_ORD_ID_COM="SELECT * FROM ordonnances WHERE  id_comm=?";

    public Ordonnance  select_ord_id_com(int id) {
        PreparedStatement St=null;
        ResultSet rs = null;
        Connection connection=null;
        Ordonnance O=new Ordonnance();
        connection= SingletonConnection.getConnection();
        try {
            St=connection.prepareStatement(SELECT_ORD_ID_COM);
            St.setInt(1,id);
            rs= St.executeQuery();
            if(rs.next()) {
                O.setId_ord(rs.getInt("id_ord"));
                O.setId_comm(rs.getInt("id_comm"));
                O.setFichier_ord(rs.getString("fichier_ord"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return O;



    }
}
