package tst;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SingletonConnection;
import model.Medicament;
import model.Ordonnance;
import model.Utilisateur;



public class OrdonnanceDAO {
	
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
