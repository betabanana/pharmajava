package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.InstanceMedicament;
import model.Medicament;
import service.authadminService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.InstanceMedicamentDAO;
import dao.MedicamentDAO;



public class ServletAjouterInstance extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletAjouterInstance() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext con=this.getServletContext();
		 String stock=request.getParameter("stock");
         HttpSession session=request.getSession();
		 String name=(String) session.getAttribute("nom");
		 String password=(String) session.getAttribute("nom");
		 if(name!=null && password!=null) {
	
			   if(stock==null){
			    	int ajeterModSUPInst=4;
			  	   con.setAttribute("ajeterModSUPInst",ajeterModSUPInst );

				   response.sendRedirect("AdminMedcamnet");
			  	
				
				}else {
						InstanceMedicament I=new InstanceMedicament();
						String strid=request.getParameter("id_med");
						I.setId_med(Integer.parseInt(strid));
						I.setQte_stock_med(Integer.parseInt(request.getParameter("stock")));
						I.setDate_exp_med(InstanceMedicamentDAO.ConverteDate(request.getParameter("date_per")));
						I.setDate_prod_med(InstanceMedicamentDAO.ConverteDate(request.getParameter("date_pro")));
						InstanceMedicamentDAO InstDAO=new  InstanceMedicamentDAO();
						
						try {
							if(InstDAO.insert(I)) {
								int ajeterModSUPInst=0;
							 	   con.setAttribute("ajeterModSUPInst",ajeterModSUPInst );
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						response.sendRedirect("AdminMedcamnet");
					
				}
			
			
		
	}else {String Ero=null;
	ServletContext conn=this.getServletContext();
	 conn.setAttribute("Ero",Ero);
	 response.sendRedirect("Admin");
}
    
    
    
    
    
    
    
    
    
    
    
		  }

}
