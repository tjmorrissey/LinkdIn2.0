<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Applicant</title>
 <script type = "text/javascript">
 	function validateUsername() {
 		var username = document.newApp.username.value;
 		var userLength = username.length;
 		
 		if(userLength < 3 || userLength > 20) {
 			alert("Username needs to be between 3 and 20 characters.")
 			document.newApp.username.focus;
 			return false;
 		}
 		return true;
 	}
 </script>
</head>
<body>
<h3>Create new User</h3>

<p style="color:red">${errorCode }</p>

<form action="createNewAppServlet" name="newApp" onsubmit="return(validateUsername());">
Create a unique Username: <br>
Username: <input type="text" name="username"> <br><br>
Enter your Full Name: <br>
Name: <input type="text" name="name"> <br><br>
Enter the City you live in: <br>
City: <input type="text" name="address"> <br><br>
Enter your Highest Level of Education: <br>
Education Level: 
<select name="educationLevel">
	<option value="No High School">No High School</option>
	<option value="High School">High School Diploma/GED</option>
	<option value="Some College">Some College</option>
	<option value="Associates">Associates Degree</option>
	<option value="Bachelor">Bachelor Degree</option>
	<option value="Master">Masters or Higher</option>
</select>

<input type="submit" value="Create User">

</form>
</body>
</html>