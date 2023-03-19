package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Commande;
import model.Medicament;
import service.authadminService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.CommandeDAO;
import dao.MedicamentDAO;



public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("nom");
		String password=(String) session.getAttribute("pass");
		
		if(name!=null && password!=null) {
			ServletContext con=this.getServletContext();
			  if(con.getAttribute("ajouterMed")!=null) {
			  int ajouterMed=(int) con.getAttribute("ajouterMed");
			     request.setAttribute("ajouterMed", ajouterMed);
			  }
			  if(con.getAttribute("ajeterModSUPInst")!=null) {
			  int ajeterModSUPInst=(int) con.getAttribute("ajeterModSUPInst");
			  request.setAttribute("ajeterModSUPInst", ajeterModSUPInst);}
			  
		      List<Medicament> med=new ArrayList<>();
	  		  MedicamentDAO MedDAO=new MedicamentDAO();
	  		   med=MedDAO.List_med_adm();
	  		   request.setAttribute("med", med);

	  	 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/admin.jsp");
	  	 rd.forward(request, response);

		}
		else {String Ero=null;
		ServletContext conn=this.getServletContext();
		 conn.setAttribute("Ero",Ero);
		 response.sendRedirect("Admin");
	}
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 ServletContext con=this.getServletContext();
		 int ajouterMed=0;
  	    con.setAttribute("ajouterMed",ajouterMed );
  	    int ajeterModSUPInst=0;
  	    request.setAttribute("ajeterModSUPInst", ajeterModSUPInst);
  	    String mot=request.getParameter("mot");
		String nom=request.getParameter("nom");
		String pass=request.getParameter("pass");
		String id=request.getParameter("id_med");
		HttpSession session=request.getSession();
		authadminService Admin=new authadminService();
		List<Medicament> med=new ArrayList<>();
		MedicamentDAO MedDAO=new MedicamentDAO();
		
		if((nom!=null && pass!=null)) {	
		  if(Admin.admin(nom, pass)){
			session.setAttribute("nom", nom);
			session.setAttribute("pass", pass);
			   med=MedDAO.List_med_adm();
			   request.setAttribute("med", med);
		 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/admin.jsp");
		 rd.forward(request, response);
		
			}else {String Ero=null;
			Ero="mot de passe ou nom incorrecte";
			ServletContext conn=this.getServletContext();
			 conn.setAttribute("Ero",Ero);
			 response.sendRedirect("Admin");
			 
		}
		
		}else if(id!=null){
				
				 ajeterModSUPInst=0;
				String gere=request.getParameter("gere");
				int test=Integer.parseInt(gere);
					if(test==1) {
						ajeterModSUPInst=1;
					}else if(test==2) {
						ajeterModSUPInst=2;
						Medicament Modifer=new Medicament();
						Modifer=MedDAO.List_med_adm_id(Integer.parseInt(id));
						request.setAttribute("Modifer", Modifer);
					}else if(test==3) {
						String name=(String) session.getAttribute("nom");
						String password=(String) session.getAttribute("pass");
						if(name!=null && password!=null) {
							MedDAO.SuppMed(Integer.parseInt(id));	
				         
						
					}else {String Ero=null;
					ServletContext conn=this.getServletContext();
					 conn.setAttribute("Ero",Ero);
					 response.sendRedirect("Admin");
				}

						
					}
					
					request.setAttribute("ajeterModSUPInst", ajeterModSUPInst);
					   request.setAttribute("ide", id);
				   med=MedDAO.List_med_adm();
				   request.setAttribute("med", med);
			 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/admin.jsp");
			 rd.forward(request, response);	
			}
		    else if(mot!=null) {
			  med=MedDAO.List_med_adm_rechercher(mot);
			   request.setAttribute("med", med);
			   RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/admin.jsp");
				 rd.forward(request, response);
		     }
		else {String Ero=null;
		Ero="mot de passe ou nom incorrecte";
		ServletContext conn=this.getServletContext();
		 conn.setAttribute("Ero",Ero);
		 response.sendRedirect("Admin");
		
		 
 	}
	
		
	}

}
