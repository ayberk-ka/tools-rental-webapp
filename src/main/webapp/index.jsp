<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="minHello-servlet">MinHelloServlet</a>
<a href="Test">Test</a>

</body>

    <title>JSP - UIA Gruppe7 </title>
</head>

<body>
<h1 style="background-color:hsla(9, 100%, 64%, 0.5);"><%= "UIA Gruppe7" %>
</h1>
<br/>

</body>
</form>
<form action="AnsattSQL" method="post" >

    Email:<br>
    <input type='text' name='userName' value=''><br>

    Password:<br>
    <input type='password' name='password' value=''><br><br>


    <input type='submit' value='Login'>

</form>

</body>

</html>
