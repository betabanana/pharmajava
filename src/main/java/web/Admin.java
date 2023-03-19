package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Admin() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext conn=this.getServletContext();
		String Ero;
		if(conn.getAttribute("Ero")!=null) {
		 Ero=(String) conn.getAttribute("Ero");
		}else {
			Ero=null;
		}
		request.getAttribute("Ero"); 
		RequestDispatcher rd=request.getRequestDispatcher("/loginAdmin.jsp");
		 rd.forward(request, response);
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
