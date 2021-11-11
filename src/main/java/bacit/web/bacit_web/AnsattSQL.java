package bacit.web.bacit_web;

import bacit.web.bacit_web.Modell.AnsattM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/AnsattSQL") // navne G7 for sikerhet sånn for ikke vise class name i url
public class AnsattSQL extends HttpServlet {

    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");            // response  Html text data type
        PrintWriter prints = response.getWriter();// hente getWriter og sitte på out2
        String fornavn = request.getParameter("fornavn");
        String etternavn = request.getParameter("etternavn");
        String email=request.getParameter("email.");
        try {
            getUser2(prints, fornavn, etternavn, email);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }








    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if (getUser(email, password, out) != null) {
                out.println("Welcome: " + email);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("</head>\n");
                out.println("<body>");
                out.println("<form action='AnsattSQL' method='Post'>");
                out.println("<h1>UIA Gruppe7</h1>");
                out.println("<p>&#128512;</p>");
                out.println("");
                out.println("<a href= 'LoggUt' >LoggUt</a>");

                // getUser3(out);

                out.println("</body>\n");
                out.println("</html>");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UserProfile");
                requestDispatcher.include(request, response);
                // getUser2(out);


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

    private AnsattM getUser(String email, String password, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query3 = "select * from ansatt where  email = ? AND password=?";
        PreparedStatement statement = db.prepareStatement(query3);

        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        AnsattM model = null;

        while (rs.next()) {
            model =
                    new AnsattM(rs.getInt("ansatt_id"),
                            rs.getString("password"),
                            rs.getString("fornavn"),
                            rs.getString("etternavn"),
                            rs.getString("adresse"),
                            rs.getString("mobil"),
                            rs.getString("email"),
                            rs.getInt("unionn"),
                            rs.getInt("administrator") );

        }
        return model;
    }



    protected void getUser2(PrintWriter prints, String fornavn, String etternavn ,String email) throws SQLException {
        Connection db;
        try {
            String query6 = "select fornavn, etternavn, email from ansatt";

            db = DBUtils.getINSTANCE().getConnection(prints);
            PreparedStatement preparedStatement = db.prepareStatement(query6);


            try (ResultSet resultSet = preparedStatement.executeQuery(query6)) {


                while (resultSet.next()) {
                    prints.println(resultSet.getString("fornavn"));
                    prints.println(resultSet.getString("etternavn"));
                    prints.println(resultSet.getString("email"));


                }
            }

            db.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}

