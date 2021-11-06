package bacit.web.bacit_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
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

        printWriter.println("<html><body style=background-color:orange;>");
        printWriter.println("<h1>UserProfile<h1>");
        printWriter.println("<h3>");

        try {
            getUser3(printWriter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        printWriter.println("<h3>");

        printWriter.println("<p>&#128512;</p>");
        printWriter.println("<a href=\"AnsattSQL\">AnsattSQL</a>\n" +
                "\t\t<form action=\"AnsattSQL\" method=\"GET\" >");

        printWriter.println("\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t<title><h1>AMV - Utstyr <h1></title>\n" +
                "\n" +
                "\n" +
                "\t<script src=\"js/jquery-2.1.4.min.js\"></script>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "\t\t</div>\n" +"                  "+
                "\"><span>Her kan du låne Utstyr</span></span></h1>\n" +


                "\t\t\t<form action=\"AnsattSQL\" method=\"post\" >\n" +
                "\n" +
                "\t\t\t<div class=\"box-header\">\n" +
                "\t\t\t\t<h2>Bestile</h2>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<label for=\"userName\">AnsattID</label>\n" +
                "\t\t\t<br/>\n" +
                "\t\t\t<input type=\"text\" id=\"userName\" name='AnsattID'>\n" +
                "\t\t\t<br/>\n" +
                "\t\t\t<label for=\"userName\">UtstyrID</label>\n" +
                "\t\t\t<br/>\n" +
                "\t\t\t<input type=\"text\" id=\"userName\" name='UtstyrID'>\n" +
                "\t\t\t<br/>\n" +
                "\t\t\t<button type=\"submit\">Bestil</button>\n" +
                "\n" +
                "\t\t\t</form>\n" +


                "<html><body");


    }

    private void getUser3( PrintWriter prints) throws SQLException {
        Connection db = null;

        try {

            String query2 = "select * from utstyr";
            db = DBUtils.getINSTANCE().getConnection(prints);
            PreparedStatement preparedStatement = db.prepareStatement(query2);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                prints.println(resultSet.getInt("utstyr_type_id"));
                prints.println(resultSet.getString("utstyr_navn"));
                prints.println(resultSet.getBigDecimal("leie_kostnad"));
                prints.println(resultSet.getBoolean( "status"));
                prints.println(resultSet.getString("bruk_info" ));

            }

            db.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }







}


 /*  AnsattSQL ansattSQL = new AnsattSQL();
        try {
            printWriter.println(ansattSQL.getUser2(printWriter));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
