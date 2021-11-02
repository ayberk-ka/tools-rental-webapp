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
@WebServlet("/Login")

public class Login extends HttpServlet {

    private static final long serialVersionUID=1L;

    public Login() {
    }
    // doPost sende data til server og ikke vise data som har blit sendt på Browser/URL, har 2 parameters request & response
// doPost kan bruke når du ønsker å overføre sikre data eks Password,bank konto for login (userName,password)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO Auto-generated constructor stub
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            if (getUser(userName,password,out)!=null) {
                response.setContentType("text/html");
                out.println("Welcome: " + userName);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("</head>\n");
                out.println("<body>");
                out.println("<form action='Login' method='getUser'>");
                out.println("<h1>UIA Gruppe7</h1>");
                out.println("<h1>Våres første WebApp</h1>");
                out.println("<p>&#128512;</p>");
                out.println("</body>\n");
                out.println("</html>");

            }
            else{
                out.println("Plaese check User/Password");
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
                requestDispatcher.include(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private UserModel getUser(String email, String password, PrintWriter out) throws SQLException {
        Connection db = null;
        try {
            db = DBUtils.getINSTANCE().getConnection(out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query3 = "select * from ansatt where  email = ? AND password=?";
        PreparedStatement statement = db.prepareStatement(query3);
        statement.setString(1,email );
        statement.setString(2,password );


        ResultSet rs = statement.executeQuery();
        UserModel model = null;
        while (rs.next()) {
            model =
                    new UserModel(rs.getString("email"), rs.getString("password"), rs.getString("fornavn"));
        }
        return model;
    }

}