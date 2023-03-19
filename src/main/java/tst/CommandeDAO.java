package tst;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrdonnanceDAO;
import dao.SingletonConnection;
import model.Commande;
import model.Medicament;
import model.Ordonnance;
import model.Utilisateur;

public class CommandeDAO {
	

	private static final String  SELECT_COM="SELECT * FROM commandes WHERE status_comm='ENCOURS'";
	private static final String  SELECT_COM_ANU_VAl="update commandes set status_comm=? where id_comm=?";
	private static final String  QTE_COMM="select  count(*) as num from commandes  where id_comm=?  ";

	public List<Commande> list_COM(){
		 String[] status= {"PANIER", "ENCOURS", "VALIDER","REFUSER"};
		 List <Commande > comms = new ArrayList < > ();
		 PreparedStatement St=null;
    	 ResultSet rs = null;
    	  Connection connection=null;
    	  OrdonnanceDAO ORDAO=new OrdonnanceDAO();
			connection= SingletonConnection.getConnection();
		
		try {	
			
			St=connection.prepareStatement(SELECT_COM);
			rs= St.executeQuery();
			while(rs.next()) {
				Commande CM=new  Commande();
            	CM.setId_comm(rs.getInt("id_comm"));
            	CM.setDate_comm(rs.getDate("date_comm"));
            	CM.setId_util(rs.getInt("id_util"));
            	CM.setPrix_comm(rs.getDouble("Prix_comm"));
            	Ordonnance o=new Ordonnance();
            	o=ORDAO.select_ord_id_com(rs.getInt("id_comm"));
            	int i=0;
            	int statausCom=0;
            	while(i<4) {
            		if(status[i].compareTo(rs.getString("status_comm"))==0){
            			statausCom=i+1;
            		}
            		i++;
            	}
            	 CM.setStatus_comm(statausCom);
            	CM.setOrd(o);
             comms.add(CM);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
	        return comms;
	}
	
	
	public void annulerValiderCom(int id,int anva) {
		 PreparedStatement St=null;
    	  Connection connection=null;
    	  connection=SingletonConnection.getConnection();
    	  try {
			St=connection.prepareStatement(SELECT_COM_ANU_VAl);
			St.setInt(1, anva);
			St.setInt(2, id);
			St.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	  
  		
	}
	
	
	
	
	
	
	
	
	
	

}
