package bacit.web.bacit_web;

import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/Test")
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Test() {
        //TODO Auto-generated constructor stub

    }

    // doPost sende data til server og ikke vise data som har blit sendt på Browser/URL, har 2 parameters request & response
// doPost kan bruke når du ønsker å overføre sikre data eks Password,bank konto for login (userName,password)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO Auto-generated constructor stub
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index2.jsp");
        requestDispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO Auto-generated constructor stub
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if ( password.equals("12345")  ) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserProfile");
            requestDispatcher.forward(request, response);

        }  else {
            printWriter.println("Plaese check User/Password");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index2.jsp");
            requestDispatcher.include(request, response);
        }
    }
}