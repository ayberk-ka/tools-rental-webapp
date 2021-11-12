package bacit.web.bacit_web;

import bacit.web.bacit_web.Modell.AnsattM;
import bacit.web.bacit_web.DAO.AnsattDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebServlet ("/Logginn")


public class Logginn extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {



    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            AnsattDAO ansattDAO = new AnsattDAO();
            AnsattM ansatt = ansattDAO.getUser(email, password, out);
            if (ansatt != null) {
                HttpSession session = request.getSession();
                session.setAttribute("ansatt", ansatt);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
                requestDispatcher.include(request, response);


            } else {
                out.println("Plaese check User/Password");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.include(request, response);
            }

        } catch (SQLException e) {
            out.println("Error" + e.getMessage());
            e.printStackTrace();
        }
    }






}