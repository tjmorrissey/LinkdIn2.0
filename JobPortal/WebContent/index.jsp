<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LinkdIn 2.0</title>
</head>
<body>
<h2>Login</h2>

<h4>Applicant Login</h4>
<form action = "appLoginServlet" method ="post">
Username: <input type="text" name="username"> <br>
Password: <input type="password" name="userPassword"> <br>
<input type="submit" value="Login as Applicant">
</form>
<br>
<a href="createNewApplicant.jsp">New Applicant</a>
<br><br>
<h4>Company Login</h4>
<form action = "employerLoginServlet" method ="post">
Company Name: <input type="text" name="username"> <br>
Password: <input type="password" name="userPassword"> <br>
<input type="submit" value="Login as Company">
</form>
<br>
<a href="newEmployerServlet">New Company</a>

<br><br><br>
Created by Alex Kuberski, Regina Cameron, and Thomas Morrissey


</body>
</html>