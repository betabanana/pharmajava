package web;

import dao.OrdonnanceDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.Ordonnance;

import java.io.File;
import java.io.IOException;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String fichier_ord = "";
        String fileName = null;
        for (Part part : request.getParts()) {
                fileName = getFileName(part);
                if(fileName != ""){

                    fichier_ord     = fileName.substring(0, fileName.lastIndexOf('.'));
                    part.write(uploadFilePath + File.separator + fileName);
                }
        }

        //request.setAttribute("message", fileName + " File uploaded successfully!");
        //getServletContext().getRequestDispatcher("/acceuil").forward(request, response);
        int id_comm = Integer.parseInt(request.getParameter("id_comm"));
        OrdonnanceDAO ordDAO = new OrdonnanceDAO();
        Ordonnance ord = new Ordonnance();
        ord.setFichier_ord(fichier_ord);
        ord.setId_comm(id_comm);
        ordDAO.insererOrdonnance(ord);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/views/commande-success.jsp");
        rd.forward(request, response);
    }

    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

}
