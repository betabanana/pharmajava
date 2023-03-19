package dao;

import model.Medicament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentDAO {

    private static final String SELECT_MED_BY_ID = "select * from medicaments where id_med =?";
    private static final String SELECT_ALL_MEDS = "select * from medicaments ";
    private static final String SELECT_ACTIVE_MEDS = "select * from medicaments where status_med = 1";
    private static final String SELECT_MOT_CLE_MEDS = "select * from medicaments where status_med = 1 and titre_med like ?";

     private static Connection con ;
    private ResultSet rs;
    private PreparedStatement pst;

    public MedicamentDAO() {
        con = SingletonConnection.getConnection();
    }
    public List<Medicament> selecterMedParMotCle(String motCle) {

        List<Medicament> meds = new ArrayList<>();
        try{
            pst = con.prepareStatement(SELECT_MOT_CLE_MEDS);
            pst.setString(1, "%"+motCle+"%");
            rs = pst.executeQuery();

            while (rs.next()) {
                int id_med = rs.getInt("id_med");
                String image_med = rs.getString("image_med");
                String titre_med = rs.getString("titre_med");
                String desc_med = rs.getString("desc_med");
                Double prix_med = rs.getDouble("prix_med");
                boolean status_ord_med = rs.getBoolean("status_ord_med");
                boolean status_med = rs.getBoolean("status_med");
                meds.add(new Medicament(id_med, image_med, titre_med, desc_med, prix_med, status_ord_med, status_med));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return meds;
    }
    public List<Medicament> selecterTousMedicamentActiver() {

        List<Medicament> meds = new ArrayList<>();
        try{
            pst = con.prepareStatement(SELECT_ACTIVE_MEDS);

            rs = pst.executeQuery();

            while (rs.next()) {
                int id_med = rs.getInt("id_med");
                String image_med = rs.getString("image_med");
                String titre_med = rs.getString("titre_med");
                String desc_med = rs.getString("desc_med");
                Double prix_med = rs.getDouble("prix_med");
                boolean status_ord_med = rs.getBoolean("status_ord_med");
                boolean status_med = rs.getBoolean("status_med");
                meds.add(new Medicament(id_med, image_med, titre_med, desc_med, prix_med, status_ord_med, status_med));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return meds;
    }

    public Medicament selecterMedicament(int id_med) {
        Medicament med = null;

        try{
            Connection con = SingletonConnection.getConnection();
                pst = con.prepareStatement(SELECT_MED_BY_ID);
            pst.setInt(1, id_med);

             rs = pst.executeQuery();

            while (rs.next()) {
                String image_med = rs.getString("image_med");
                String titre_med = rs.getString("titre_med");
                String desc_med = rs.getString("desc_med");
                Double prix_med = rs.getDouble("prix_med");
                boolean status_ord_med = rs.getBoolean("status_ord_med");
                boolean status_med = rs.getBoolean("status_med");

                med = new Medicament(id_med, image_med, titre_med, desc_med, prix_med, status_ord_med, status_med);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return med;
    }

    public List<Medicament> selecterTousMedicament() {

        List<Medicament> meds = new ArrayList<>();
        try{
                pst = con.prepareStatement(SELECT_ALL_MEDS);

             rs = pst.executeQuery();

            while (rs.next()) {
                int id_med = rs.getInt("id_med");
                String image_med = rs.getString("image_med");
                String titre_med = rs.getString("titre_med");
                String desc_med = rs.getString("desc_med");
                Double prix_med = rs.getDouble("prix_med");
                boolean status_ord_med = rs.getBoolean("status_ord_med");
                boolean status_med = rs.getBoolean("status_med");
                meds.add(new Medicament(id_med, image_med, titre_med, desc_med, prix_med, status_ord_med, status_med));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return meds;
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

    private static final String INSERT_MED="insert into medicaments(image_med,titre_med,desc_med,prix_med,status_ord_med,status_med) values(?,?,?,?,?,?)";
    private static final String SELECT_MEDS_STATUS="select * from medicaments where status_med = true;";
    private static final String SELECT_MEDS_STATUS_id="select * from medicaments where id_med=? ;";
    private static final String UPDAT_MED="update medicaments set image_med=?,titre_med=?,desc_med=?,prix_med=?,status_ord_med=? WHERE id_med=?;";



    public List<Medicament> List_med_adm()  {
        List<Medicament> Ls=new ArrayList();
        PreparedStatement St=null;
        ResultSet rs = null;
        Connection connection=null;

        connection= SingletonConnection.getConnection();

        try {

            St=connection.prepareStatement(SELECT_MEDS_STATUS);
            rs= St.executeQuery();
            while(rs.next()) {
                Medicament M=new Medicament();
                M.setId_med(rs.getInt("id_med"));
                M.setTitre_med(rs.getString("titre_med"));
                M.setImage_med(rs.getString("image_med"));
                M.setDesc_med(rs.getString("desc_med"));
                M.setPrix_med(rs.getDouble("prix_med"));
                M.setStatus_med(rs.getBoolean("status_med"));
                M.setStatus_ord_med(rs.getBoolean("status_ord_med"));
                M.setNbr_Instante(dao.InstanceMedicamentDAO.Qte_Stk_med(rs.getInt("id_med")));
                Ls.add(M);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Ls;
    }



    public Medicament List_med_adm_id(int id)  {
        PreparedStatement St=null;
        ResultSet rs = null;
        Connection connection=null;
        Medicament M=new Medicament();

        connection=SingletonConnection.getConnection();

        try {

            St=connection.prepareStatement(SELECT_MEDS_STATUS_id);
            St.setInt(1,id);
            rs= St.executeQuery();
            if(rs.next()) {
                M.setId_med(rs.getInt("id_med"));
                M.setTitre_med(rs.getString("titre_med"));
                M.setImage_med(rs.getString("image_med"));
                M.setDesc_med(rs.getString("desc_med"));
                M.setPrix_med(rs.getDouble("prix_med"));
                M.setStatus_med(rs.getBoolean("status_med"));
                M.setStatus_ord_med(rs.getBoolean("status_ord_med"));
                M.setNbr_Instante(0);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return M;
    }


    public boolean insertMed(Medicament M){
        Connection connection=null;
        PreparedStatement St=null;

        connection=SingletonConnection.getConnection();

        try {
            St=connection.prepareStatement(INSERT_MED);
            St.setString(1,M.getImage_med());
            St.setString(2,M.getTitre_med());
            St.setString(3,M.getDesc_med());
            St.setDouble(4, M.getPrix_med());
            St.setBoolean(5,M.getStatus_ord_med());
            St.setBoolean(6, true);
            St.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }
    public void ModiferMed(Medicament M){
        Connection connection=null;
        PreparedStatement St=null;

        connection=SingletonConnection.getConnection();

        try {
            St=connection.prepareStatement(UPDAT_MED);
            St.setString(1, M.getImage_med());
            St.setString(2, M.getTitre_med());
            St.setString(3, M.getDesc_med());
            St.setDouble(4, M.getPrix_med());
            St.setBoolean(5, M.getStatus_ord_med());
            St.setInt(6, M.getId_med() );
            St.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void SuppMed(int id){
        Connection connection=null;
        PreparedStatement St=null;

        connection=SingletonConnection.getConnection();

        try {
            St=connection.prepareStatement("UPDATE medicaments SET status_med=false  WHERE id_med='"+id+"';");
            St.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public List<Medicament> List_med_adm_rechercher(String mot)  {
        List<Medicament> Ls=new ArrayList();
        PreparedStatement St=null;
        ResultSet rs = null;
        Connection connection=null;

        connection=SingletonConnection.getConnection();

        try {

            St=connection.prepareStatement("select * from medicaments where status_med = true and titre_med like '"+mot+"%' ;");
            rs= St.executeQuery();
            while(rs.next()) {
                Medicament M=new Medicament();
                M.setId_med(rs.getInt("id_med"));
                M.setTitre_med(rs.getString("titre_med"));
                M.setImage_med(rs.getString("image_med"));
                M.setDesc_med(rs.getString("desc_med"));
                M.setPrix_med(rs.getDouble("prix_med"));
                M.setStatus_med(rs.getBoolean("status_med"));
                M.setStatus_ord_med(rs.getBoolean("status_ord_med"));
                M.setNbr_Instante(dao.InstanceMedicamentDAO.Qte_Stk_med(rs.getInt("id_med")));
                Ls.add(M);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Ls;
    }

    public List<Medicament> List_med_adm_Date()  {
        List<Medicament> Ls=new ArrayList();
        PreparedStatement St=null;
        ResultSet rs = null;
        Connection connection=null;
        java.util.Date date=new Date(0);
        long time = date.getTime() ; // Nombre de millisecondes écoulées depuis le 1er janvier 1970
        Date sqlDate = new Date(time);


        connection=SingletonConnection.getConnection();

        try {

            St=connection.prepareStatement("select * from medicaments,instances_med where medicaments.id_med=instances_med.id_med  and status_med = true and date_exp_med>'"+sqlDate+"';");
            rs= St.executeQuery();
            while(rs.next()) {
                Medicament M=new Medicament();
                M.setId_med(rs.getInt("id_med"));
                M.setTitre_med(rs.getString("titre_med"));
                M.setImage_med(rs.getString("image_med"));
                M.setDesc_med(rs.getString("desc_med"));
                M.setPrix_med(rs.getDouble("prix_med"));
                M.setStatus_med(rs.getBoolean("status_med"));
                M.setStatus_ord_med(rs.getBoolean("status_ord_med"));
                M.setNbr_Instante(InstanceMedicamentDAO.Qte_Stk_med(rs.getInt("id_med")));
                Ls.add(M);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Ls;
    }



}
