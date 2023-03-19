package tst;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.SingletonConnection;
import model.InstanceMedicament;
import model.Medicament;

public class InstanceMedicamentDAO {


	 PreparedStatement St=null;
	 ResultSet rs = null;
	 private static final String SELECT_ALL_Inst= "select * from instances_med ";
	 private static final String QTE_STEQ= "select sum(qte_stock_med) as sm from instances_med where id_med=? ";
	 private static final String SELECT_ALL_Inst_ID= "select * from instances_med where id_med=?";
	 private static final String Insert_Inst= "INSERT INTO instances_med(date_exp_med,date_prod_med,qte_stock_med,id_med) VALUES(?,?,?,?);  ";
	 

	 public static Date ConverteDate(String d) {
		 Date sqlDate=null;
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
