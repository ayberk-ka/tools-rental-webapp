package bacit.web.bacit_web.kontroller;

import bacit.web.bacit_web.DAO.UtstyrDAO;
import bacit.web.bacit_web.Modell.UtstyrM;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UtstyrServlet")
public class UtstyrServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UtstyrServlet() {

        //TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO Auto-generated constructor stub

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        UtstyrDAO utstyrDAO = new UtstyrDAO();

        try {
            ArrayList<UtstyrM> utstyr = utstyrDAO.getUtsty(false, printWriter); // her hentet Utstyr fra DB

            request.setAttribute("utstyr", utstyr);  // vi har request og gi Attribute Parameter (utstyr) fra utstyr
            if (utstyr != null){
                request.getRequestDispatcher("utstyr.jsp").forward(request, response); // send og flyte videre til jsp

            }
            else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }


    }

}
