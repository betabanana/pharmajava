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


public class ServletModifer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletModifer() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	HttpSession session=request.getSession();
		String name=(String) session.getAttribute("nom");
		String password=(String) session.getAttribute("pass");
		if(name!=null && password!=null) {
			Medicament M=new Medicament();
			M.setImage_med(request.getParameter("image"));
			M.setTitre_med(request.getParameter("nom"));
			M.setDesc_med(request.getParameter("desc"));
			String a=request.getParameter("prix");
			double prix=Double.parseDouble(a);
			M.setPrix_med(prix);
			String d=request.getParameter("ordo");
	          boolean booll=Boolean.parseBoolean(d);
	          M.setStatus_ord_med(booll);
	          MedicamentDAO MedDAO=new MedicamentDAO();
	          MedDAO.ModiferMed(M);
	          response.sendRedirect("AdminMedcamnet");
	}else {String Ero=null;
	ServletContext conn=this.getServletContext();
	 conn.setAttribute("Ero",Ero);
	 response.sendRedirect("Admin");;
}
          
          
          
          
          
          
          
          
          
          
          
          
	}

}
