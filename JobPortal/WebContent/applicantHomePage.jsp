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
<p align="right">"${appicant.username }"</p>

<form action="editAppServlet" method="post">
Username:  ${applicant.username} <br>
Full Name: ${applicant.name}	 <br>
City:	   ${applicant.address}	 <br>
Education Level: ${applicant.educationLevel} <br>

<input type="hidden" name ="appId" value="${applicant.applicantId})">
<input type="submit" value="Update Information">
</form>

<form action="navigateAppJobListServlet">
<h4>Jobs Applied For:</h4>
<table>
	<c:forEach var="jobsAppliedFor" items="${applicant.jobsAppliedFor }">
	<tr>
		<td> ${jobsAppliedFor.title } </td>
	</tr>
	<tr>	
		<td> ${jobsAppliedFor.employer.company } </td>
	</tr>
	<tr>
		<td> ${jobsAppliedFor.jobdesc } </td>
	</tr>
	</c:forEach>
	</table>
</form>

</body>
</html>