package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Commande;
import model.Medicament;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.CommandeDAO;
import dao.MedicamentDAO;


public class AdminMedicamentaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminMedicamentaff() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	HttpSession session=request.getSession();
			String name=(String) session.getAttribute("nom");
			String password=(String) session.getAttribute("pass");
			if(name!=null && password!=null) {
				String id=request.getParameter("id_med");
				String gere=request.getParameter("gere");
				if(id!=null && gere!=null ) {
					List<Medicament> med=new ArrayList<>();
					MedicamentDAO MedDAO=new MedicamentDAO();
					Medicament Modifer=new Medicament();
					Modifer=MedDAO.List_med_adm_id(Integer.parseInt(id));
					int ajeterModSUPInst=5;
					request.setAttribute("ajeterModSUPInst", ajeterModSUPInst);
					request.setAttribute("Modifer", Modifer);
					  med=MedDAO.List_med_adm();
					   request.setAttribute("med", med);
				 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/admin.jsp");
				 rd.forward(request, response);
				}
				
		          
		}else {String Ero=null;
		ServletContext conn=this.getServletContext();
		 conn.setAttribute("Ero",Ero);
		 response.sendRedirect("Admin");
	}
	}

}
