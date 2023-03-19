package dao;

import model.MedicamentCommander;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentCommanderDAO {

    private static final String INSERT_MED_COMM = "INSERT INTO med_comm ("
            + "id_comm ,"
            + "qte_comm ,"
            + "id_instance_med "
            + ") VALUES  (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select * from utilisateurs where id_util = ?";
    private static final String SELECT_MED_COMM_BY_USER = "SELECT * FROM medicaments m " +
            "where exists (select * from instances_med im " +
            "where exists (select * from med_comm mc " +
            "where mc.id_instance_med = im.id_instance_med) " +
            "and im.id_med = ?)";
    private static final String SELECT_MEDCOM = "select * from med_comm";
    private static final String SELECT_MEDCOM_BY_COMM = "select * from med_comm where id_comm = ?";
    private static Connection con ;
    private ResultSet rs;
    private PreparedStatement pst;
    public MedicamentCommanderDAO() {
        con = SingletonConnection.getConnection();
    }


    public List<MedicamentCommander> listMedCommParComm(int id_comm){
        List<MedicamentCommander> listMedComm = new ArrayList<>();
       try {
           pst = con.prepareStatement(SELECT_MEDCOM_BY_COMM);
           pst.setInt(1, id_comm);
           rs = pst.executeQuery();

           while(rs.next()){

               MedicamentCommander medcomm;
               int id_med_comm = rs.getInt("id_med_comm");
               int id_instance_med = rs.getInt("id_instance_med");
               int qte_comm = rs.getInt("qte_comm");
               medcomm = new MedicamentCommander(id_med_comm, id_comm, id_instance_med, qte_comm);
               listMedComm.add(medcomm);
           }
       }
       catch (SQLException e){
           e.printStackTrace();
       }
       return listMedComm;
    }
    public void insererMedComm(int id_comm,int qte_comm,int id_instance_med) {
        try {
             pst  = con.prepareStatement(INSERT_MED_COMM);

            pst.setInt(1, id_comm);
            pst.setInt(2, qte_comm);
            pst.setInt(3, id_instance_med);
           
            pst.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
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
    private static final String SELECT_QTE_COM_id_com="SELECT   sum(qte_comm) as qte_comm FROM med_comm WHERE id_comm=?;";
    public int Qte_com(int id) {
        PreparedStatement St=null;
        ResultSet rs = null;
        Connection connection=null;

        connection= SingletonConnection.getConnection();

        try {

            St=connection.prepareStatement(SELECT_QTE_COM_id_com);
            St.setInt(1, id);
            rs= St.executeQuery();
            if(rs.next()){
                int a=rs.getInt("qte_comm");
                return a;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}
