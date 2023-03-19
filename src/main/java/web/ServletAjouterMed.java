package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Medicament;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.MedicamentDAO;


public class ServletAjouterMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletAjouterMed() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("loginAdmin.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext con=this.getServletContext();
		 int ajouterMed=0;
	  	 con.setAttribute("ajouterMed",ajouterMed );
	  	int ajeterModSUPInst=0;
	    request.setAttribute("ajeterModSUPInst", ajeterModSUPInst);
	  	HttpSession session=request.getSession();
		String name=(String) session.getAttribute("nom");
		String password=(String) session.getAttribute("pass");
		if(name!=null && password!=null) {
		if(request.getParameter("image")!=null && request.getParameter("nom")!=null && request.getParameter("desc")!=null && request.getParameter("prix")!=null && request.getParameter("ordo")!=null) {
	    Medicament M=new Medicament();
		M.setImage_med(request.getParameter("image"));
		M.setTitre_med(request.getParameter("nom"));
		M.setDesc_med(request.getParameter("desc"));
		double prix=Double.parseDouble(request.getParameter("prix"));
		M.setPrix_med(prix);
          boolean booll=Boolean.parseBoolean(request.getParameter("ordo"));
          M.setStatus_ord_med(booll);
          MedicamentDAO MedDao=new MedicamentDAO();
       if(MedDao.insertMed(M)) {
    	    ajouterMed=0;
    	   con.setAttribute("ajouterMed",ajouterMed );
    	   response.sendRedirect("AdminMedcamnet");
       }else {
    	    ajouterMed=1;
    	   con.setAttribute("ajouterMed",ajouterMed );
    	   response.sendRedirect("AdminMedcamnet");
       }
       }
		else {
			
	    	    ajouterMed=1;
	    	   con.setAttribute("ajouterMed",ajouterMed );
	    	   response.sendRedirect("AdminMedcamnet");
		}
      
         
		
	}else {String Ero=null;
	ServletContext conn=this.getServletContext();
	 conn.setAttribute("Ero",Ero);
	 response.sendRedirect("Admin");
}

		
		
		
		}

}
