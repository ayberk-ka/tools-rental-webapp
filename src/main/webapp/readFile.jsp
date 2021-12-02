<%@ page import="bacit.web.bacit_web.Modell.AnsattM" %><%--
  Created by IntelliJ IDEA.
  User: Ms-ka
  Date: 11/13/2021
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        AnsattM ansattM = (AnsattM) session.getAttribute("ansatt");
        if (null == ansattM) {
            response.sendRedirect("index.jsp");
        }
    %>
</head>
<body style="background-color: orange;">
<jsp:include page="menu.html"></jsp:include>

<form method="get" action="FileReadPdfServlet">
    <table>
        <tr>
            <td>Enter Lease Id</td>
            <td>
                <input type="text" name="leaseId" id="leaseId"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Get Lease"/></td>
        </tr>
    </table>
</form>
</body>
</html>
