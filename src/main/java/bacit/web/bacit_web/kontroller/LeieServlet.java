package bacit.web.bacit_web.kontroller;
import bacit.web.bacit_web.DAO.LeieDAO;
import bacit.web.bacit_web.Modell.LeieM;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/LeieServlet")



public class LeieServlet extends HttpServlet {

    public LeieServlet()  {

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String start_leie_dato= request.getParameter("start_leie_dato");
        String tilbake_dato= request.getParameter("tilbake_dato");
        Date start_leie;
        Date tilbake;


        try {
            start_leie = (Date) formatter.parse(start_leie_dato);
            tilbake = (Date) formatter.parse(tilbake_dato);

        LeieM leieM = new LeieM(
                Integer.parseInt(request.getParameter("ansatt_id")),
                Integer.parseInt(request.getParameter("utstyr_id")),
                start_leie,
                tilbake,
                Integer.parseInt(request.getParameter("betalt")),
               Float.parseFloat(request.getParameter("total_kostnad")),
                request.getParameter("tilstandsvurdering")
        );




            LeieDAO leieDAO = new LeieDAO();
            boolean succses= leieDAO.saveLeie(leieM, printWriter);
            if (succses==true) {

                printWriter.println("<script>window.location.href = \"home.jsp\" </script>");
            }
            else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException | ParseException e) {
            printWriter.println(e.getMessage());
        }
    }

}
