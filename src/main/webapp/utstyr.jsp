<%@ page import="bacit.web.bacit_web.Modell.UtstyrM" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Utstyr List</title>
</head>
<%
    AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
    if (null == ansattM) {
        response.sendRedirect("index.jsp");
    }
    ArrayList<UtstyrM> utstyr = (ArrayList<UtstyrM>) request.getAttribute("utstyr");
%>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>
<div class="container">
    <h2>Ledig Utstyr</h2>
    <table class="table table-striped">
        <thead>

    <tr>
        <th>UtstyrID</th>
        <th>Utstyr typeID</th>
        <th>Navn</th>
        <th>Info</th>
        <th>Status: False=Ledig / True=Opptatt</th>
        <th>leie_kostnad</th>

    </tr>
        </thead>
        <tbody>
        <form action="UtstyrServlet" method="GET">

        <%   for(UtstyrM u : utstyr) { %>
        <tr>
            <td> <span>  <%=u.getUtstyr_id()%></span>
            </td>
            <td> <span>  <%=u.getUtstyr_type_id()%></span>
            </td>

        <td> <span>  <%=u.getUtstyr_navn()%></span>
        </td>
        <td> <span>  <%=u.getBruk_info()%></span>
        </td>
            <td> <span>  <%=u.isStatus()%></span>
            </td>
            <td> <span>  <%=u.getLeie_kostnad()%></span>
            </td>
        </tr>
<% }%>
        </form>
        </tbody>
</table>

</div>
</body>
</html>