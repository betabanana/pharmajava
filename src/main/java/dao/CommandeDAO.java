package dao;

import model.Commande;
import model.Ordonnance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {

	private static final String INSERT_ORDERS = "INSERT INTO commandes (" + "status_comm," + "id_util , "
			+ "date_comm ," + "prix_comm " + ") VALUES  (?, ?, ?, ?);";
	private static final String SELECT_ORDER_BY_ID = "select * from commandes where id_comm =?";
	private static final String SELECT_ALL_ORDERS = "select * from commandes";
	private static final String UPDATE_ORDER_STATUS = "update commandes SET status_comm = ? where id_comm = ?";
	private static final String  SELECT_COM="SELECT * FROM commandes WHERE status_comm='ENCOURS'";
	private static final String  SELECT_COM_ANU_VAl="update commandes set status_comm=? where id_comm=?";
	// pour selectioner la commande par type (panier , encours, valider, refuser )
	private static final String SELECT_ORDER_BY_STATUS = "select * from commandes where status_comm = ? LIMIT 1";
	private static final String UPDATE_ORDER_PRICE = "update commandes set prix_comm = ?   where id_comm = ?  ";

	private static Connection con ;
	private  ResultSet rs ;
	private  PreparedStatement pst;
	public CommandeDAO() {
		 con = SingletonConnection.getConnection();
	}
	public Commande selecterCommandeParStatus(int status_comm) {
		Commande comm = null;

		try{
			pst = con.prepareStatement(SELECT_ORDER_BY_STATUS);
			pst.setInt(1, status_comm);
			 rs = pst.executeQuery();

			if (rs.next()) {
				int id_comm = rs.getInt("id_comm");
				int id_util = rs.getInt("id_util");
				Date date_comm = rs.getDate("date_comm");

				comm = new Commande( id_comm,  status_comm,  id_util,   date_comm);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return comm;
	}
	public void insererCommande(Commande comm) {
		try  {
			Connection con = SingletonConnection.getConnection();
			pst = con.prepareStatement(INSERT_ORDERS);
			pst.setInt(1, comm.getStatus_comm());
			pst.setInt(2, comm.getId_util());
			pst.setDate(3, comm.getDate_comm());
			pst.setDouble(4, comm.getPrix_comm());
			pst.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	// ici le status comm peut etre soit 1 , 2 , 3 ou 4
	// 1 => PANIER
	// 2 => ENCOURS
	// 3 => VALIDER
	// 4 => REFUSER
	public void changerStatusCommande(int id_comm, int status_comm) {
		try (PreparedStatement preparedStatement = con.prepareStatement(UPDATE_ORDER_STATUS)) {
			preparedStatement.setInt(2, id_comm);
			preparedStatement.setInt(1, status_comm);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Commande selecterCommande(int id_comm) {
		Commande comm = null;

		try   {
			pst = con.prepareStatement(SELECT_ORDER_BY_ID);
			pst.setInt(1, id_comm);

			 rs = pst.executeQuery();

			while (rs.next()) {
				int status_comm = rs.getInt("status_comm");
				int id_util = rs.getInt("id_util");
				int id_ord = rs.getInt("id_ord");
				Date date_comm = rs.getDate("date_comm");

				comm = new Commande(id_comm, status_comm, id_util, date_comm);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}

		return comm;
	}
	public List<Commande> selecterToutesCommandes() {

		List<Commande> comms = new ArrayList<>();
		try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_ORDERS);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id_comm = rs.getInt("id_comm");
				int status_comm = rs.getInt("status_comm");
				int id_util = rs.getInt("id_util");
				int id_ord = rs.getInt("id_ord");
				Date date_comm = rs.getDate("date_comm");
				comms.add(new Commande(id_comm, status_comm, id_util, date_comm));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return comms;
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
	public void modifierPrixComm(int id_comm, Double prix_comm){
		PreparedStatement St=null;
		Connection connection=null;
		connection=SingletonConnection.getConnection();
		try {
			St=connection.prepareStatement(UPDATE_ORDER_PRICE);
			St.setDouble(1, prix_comm);
			St.setInt(2, id_comm);
			St.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
