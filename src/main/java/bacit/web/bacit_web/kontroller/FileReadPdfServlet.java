package bacit.web.bacit_web.kontroller;

import bacit.web.bacit_web.DAO.FileDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileReadPdfServlet")
public class FileReadPdfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileReadPdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String leaseId = request.getParameter("leaseId")!=null?request.getParameter("leaseId"):"NA";
        ServletOutputStream sos;
        response.setContentType("application/pdf");

        response.setHeader("Content-disposition","inline; filename="+leaseId+".pdf" );


        sos = response.getOutputStream();

        ResultSet rset=null;
        try {
            FileDAO fileDAO = new FileDAO();
            rset = fileDAO.getFile(leaseId);
            if (rset.next())
                sos.write(rset.getBytes("leaseContent"));
            else
                return;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        sos.flush();
        sos.close();

    }
}
