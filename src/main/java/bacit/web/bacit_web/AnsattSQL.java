package bacit.web.bacit_web;

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

@WebServlet("/AnsattSQL")
public class AnsattSQL extends HttpServlet {

    private static final long serialVersionUID = 1L;



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO Auto-generated constructor stub
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            if (getUser(userName, password, out) != null) {
                response.setContentType("text/html");
                out.println("Welcome: " + userName);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("</head>\n");
                out.println("<body>");
                out.println("<form action='AnsattSQL' method='GET'>");
                out.println("<h1>UIA Gruppe7</h1>");
                out.println("<h1>Våres første WebApp</h1>");
                out.println("<p>&#128512;</p>");
                out.println("</body>\n");
                out.println("</html>");
                getUser2(out);
            } else {
                out.println("Plaese check User/Password");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.include(request, response);
            }
        } catch (SQLException e) {
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
                    new AnsattM(rs.getString("email"), rs.getString("password"));
        }
        return model;
    }



    private void getUser2( PrintWriter prints) throws SQLException {
        Connection db = null;
        try {

            String query2 = "select * from ansatt";
            db = DBUtils.getINSTANCE().getConnection(prints);
            PreparedStatement preparedStatement = db.prepareStatement(query2);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                prints.println(resultSet.getString("fornavn"));
                prints.println(resultSet.getString("etternavn"));

            }

            db.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

