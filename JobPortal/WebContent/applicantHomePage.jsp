<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applicant Page</title>
</head>
<body>
<form action="editAppServlet" method="post">
Username:  ${applicant.username} <br>
Full Name: ${applicant.name}	 <br>
City:	   ${applicant.address}	 <br>
Education Level: ${applicant.educationLevel} <br>

<input type="hidden" name ="appId" value="${applicant.applicantId})">
<input type="submit" value="Update Information">
</form>



</body>
</html>