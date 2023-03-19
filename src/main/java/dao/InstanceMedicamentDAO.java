package dao;

import model.InstanceMedicament;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InstanceMedicamentDAO {


    private static Connection con ;
    private ResultSet rs;
    private PreparedStatement pst;
    private static final String SELECT_ALL_Inst = "select * from instances_med ";
    private static final String Insert_Inst = "INSERT INTO instances_med(date_exp_med,date_prod_med,qte_stock_med,id_med) VALUES(?,?,?,?);  ";
    private static final String SELECT_INSTANCE_BY_ID = "select * from instances_med where id_instance_med = ?";
    private static final String SELECT_INSTANCE_BY_MED_ID = "select a.* from instances_med as a, med_comm as b where a.id_med = ? and a.id_med <> b.id_instance_med LIMIT 1;";
    private static final String SELECT_FREE_INSTANCES_BY_MED_ID = "select  a.id_instance_med, date_exp_med, date_prod_med, qte_stock_med, a.id_med from instances_med as a inner join med_comm as b  on a.id_instance_med <> b.id_instance_med where a.id_med = ?;";
    private static final String SELECT_INSTANCE_NON_COMMANDER = "select  im.* from instances_med im  where  im.id_med = ? AND EXISTS( SELECT * FROM medicaments m where m.status_med = TRUE) AND im.qte_stock_med > 0;";
    private static final String ADD_QTE_STOCK_INSTANCE =" UPDATE instances_med SET qte_stock_med = qte_stock_med + 1 WHERE id_instance_med = ?";
    private static final String REMOVE_QTE_STOCK_INSTANCE =" UPDATE instances_med SET qte_stock_med = qte_stock_med - 1 WHERE id_instance_med = ?";

    private static final String QTE_INSTANCE_MED = "SELECT qte_stock_med FROM instances_med WHERE id_instance_med = ?";
    public InstanceMedicamentDAO() {
        con = SingletonConnection.getConnection();
    }



    public static Date ConverteDate(String d) {
        Date sqlDate = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // Format de la chaîne de caractères
        try {
            java.util.Date date = df.parse(d); // Conversion de la chaîne en Date
            long time = date.getTime(); // Nombre de millisecondes écoulées depuis le 1er janvier 1970
            sqlDate = new Date(time);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return sqlDate;
    }

    public List<InstanceMedicament> List_Inst() {
        List<InstanceMedicament> Inst = new ArrayList<InstanceMedicament>();

        try {
            Connection connection = SingletonConnection.getConnection();
            pst= connection.prepareStatement(SELECT_ALL_Inst);
            rs = pst.executeQuery();
            while (rs.next()) {
                InstanceMedicament Ins = new InstanceMedicament();
                Ins.setId_instance_med(rs.getInt("id_instance_med"));
                Ins.setId_med(rs.getInt("id_med"));
                Ins.setQte_stock_med(rs.getInt("qte_stock_med"));
                Ins.setDate_exp_med(rs.getDate("date_exp_med"));
                Ins.setDate_prod_med(rs.getDate("date_prod_med"));
                Inst.add(Ins);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Inst;

    }

    public InstanceMedicament selecterInstanceMedicament(int id_instance_med) {

        InstanceMedicament Ins = null;
        try {
            pst = con.prepareStatement(SELECT_INSTANCE_BY_ID);
           pst.setInt(1, id_instance_med);
            rs =pst.executeQuery();
            while (rs.next()) {
                Ins = new InstanceMedicament();
                Ins.setId_instance_med(rs.getInt("id_instance_med"));
                Ins.setId_med(rs.getInt("id_med"));
                Ins.setQte_stock_med(rs.getInt("qte_stock_med"));
                Ins.setDate_exp_med(rs.getDate("date_exp_med"));
                Ins.setDate_prod_med(rs.getDate("date_prod_med"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Ins;

    }
    public InstanceMedicament selecterInstanceMedParMedId(int id_med) {

        InstanceMedicament Ins = null;
        try {
            pst = con.prepareStatement(SELECT_INSTANCE_NON_COMMANDER);
           pst.setInt(1, id_med);
            rs =pst.executeQuery();
            if (rs.next()) {
                Ins = new InstanceMedicament();
                Ins.setId_instance_med(rs.getInt("id_instance_med"));
                Ins.setId_med(rs.getInt("id_med"));
                Ins.setQte_stock_med(rs.getInt("qte_stock_med"));
                Ins.setDate_exp_med(rs.getDate("date_exp_med"));
                Ins.setDate_prod_med(rs.getDate("date_prod_med"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Ins;

    }
    public List<InstanceMedicament> listInstanceParMedId(int id_med) {
        List<InstanceMedicament> Inst = new ArrayList<>();
        InstanceMedicament Ins = null;

        try {
            pst = con.prepareStatement(SELECT_INSTANCE_NON_COMMANDER);
            pst.setInt(1, id_med);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id_instance_med = rs.getInt("id_instance_med");
                int qte_stock_med = rs.getInt("qte_stock_med");
                Date date_exp_med = rs.getDate("date_exp_med");
                Date date_prod_med = rs.getDate("date_prod_med");


                Ins = new InstanceMedicament(id_instance_med, date_exp_med, date_prod_med, qte_stock_med,id_med);
                Inst.add(Ins);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Inst;

    }
    public int qteInstanceMed(int id_instance_med){
int qte_stock_med = 0;
        try {
            pst = con.prepareStatement(QTE_INSTANCE_MED);
            pst.setInt(1, id_instance_med);
            rs = pst.executeQuery();
            if (rs.next()) {
                 qte_stock_med = rs.getInt("qte_stock_med");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return qte_stock_med;
    }

    public void commanderInstance(int id_instance_med) {

        try {
            pst = con.prepareStatement(REMOVE_QTE_STOCK_INSTANCE);
            pst.setInt(1, id_instance_med);
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }



}
    PreparedStatement St=null;
    private static final String QTE_STEQ= "select sum(qte_stock_med) as sm from instances_med where id_med=? ";
    private static final String SELECT_ALL_Inst_ID= "select * from instances_med where id_med=?";



    public static int  Qte_Stk_med(int id){
        PreparedStatement St=null;
        ResultSet rs = null;
        Connection connection=null;
        int qte=0;
        connection= SingletonConnection.getConnection();
        try {	St=connection.prepareStatement(QTE_STEQ);
            St.setInt(1, id);
            rs= St.executeQuery();
            if(rs.next()){
                qte=rs.getInt("sm");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return qte;

    }
    public boolean insert(InstanceMedicament I) throws SQLException {
        Connection connection;

        connection = SingletonConnection.getConnection();
        St=connection.prepareStatement(Insert_Inst);
        St.setDate(1, I.getDate_exp_med());
        St.setDate(2, I.getDate_prod_med());
        St.setInt(3, I.getQte_stock_med());
        St.setInt(4, I.getId_med());
        St.executeUpdate();
        return true;




    }
}