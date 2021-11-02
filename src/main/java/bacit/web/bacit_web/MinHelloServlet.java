package bacit.web.bacit_web;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;


@WebServlet(name = "MinHelloServlet", value = "/minHello-servlet")  //Servlet name
public class MinHelloServlet extends HttpServlet { // MinHelloServlet er en class som skal arve alle method og data fra HttpServlet
    private String message;

    public void init() {
        message = "Hello World!";
    }

    // doGet sende data til server og vise data som har blit sendt på Browser/URL, har 2 parameters request & response
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");  // utgående type data er tekst/html

        // Hello
        PrintWriter out = response.getWriter(); // åpne kanal mellom Server og Browser og ber servlet å svare på brukerforespørsler

        out.println("<html><body>");                              //HTML kode
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>Hent info From Database :-)</h1>");
        out.println("<form action='GetUserServlet' method='GET'>");
        out.println("  <label for='uname'>First name:</label>");
        out.println("  <input type='text' name='uname'/>");
        out.println("  <input type='submit' />");
        out.println("</form>");
        out.println("</body></html>");
    }                                    //alt mellom sitatene skal printe ut på Browser



    public void destroy() {
    }
}