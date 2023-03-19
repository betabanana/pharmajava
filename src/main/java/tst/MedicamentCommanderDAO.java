package tst;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SingletonConnection;
import model.Medicament;
import model.Utilisateur;

public class MedicamentCommanderDAO {
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
