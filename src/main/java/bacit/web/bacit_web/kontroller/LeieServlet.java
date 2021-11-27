package bacit.web.bacit_web.kontroller;
import bacit.web.bacit_web.DAO.LeieDAO;
import bacit.web.bacit_web.Modell.LeieM;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/LeieServlet")



public class LeieServlet extends HttpServlet {

    public LeieServlet()  {

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String startDato= request.getParameter("start_leie_dato");
        String tilbakeDato= request.getParameter("tilbake_dato");
        Date start_leie_dato = null;
        Date tilbake_dato = null;

        try {
            start_leie_dato = formatter.parse(startDato);
            tilbake_dato = formatter.parse(tilbakeDato);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        LeieM leieM = new LeieM(
                Integer.parseInt(request.getParameter("ansatt_id")),
                Integer.parseInt(request.getParameter("utstyr_id")),
                start_leie_dato,
                tilbake_dato,
                Integer.parseInt(request.getParameter("betalt")),
               Float.parseFloat(request.getParameter("total_kostnad")),
                request.getParameter("tilstandsvurdering")


        );


        try {

            LeieDAO leieDAO = new LeieDAO();
            Boolean succses= leieDAO.saveLeie(leieM, printWriter);
            if (succses==true) {

                printWriter.println("<script>window.location.href = \"home.jsp\" </script>");
            }
            else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            printWriter.println(e.getMessage());
        }
    }

}
