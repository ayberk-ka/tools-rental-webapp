package bacit.web.bacit_web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserProfile() {

        //TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //TODO Auto-generated constructor stub

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        String userName = request.getParameter("userName");

        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html><body>");
        printWriter.println("<html><body style=background-color:powderblue;>");
        printWriter.println("<h1>UserProfile<h1>");
        printWriter.println("</h1> Welcome "+ userName + "</h1>");
        printWriter.println("<h1>UIA Gruppe7</h1>");
        printWriter.println("<h1>Våres første WebApp</h1>");
        printWriter.println("<p>&#128512;</p>");
        printWriter.println("<html><body");
    }

}