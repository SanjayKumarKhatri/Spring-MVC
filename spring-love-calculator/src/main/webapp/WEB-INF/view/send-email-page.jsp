<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Page</title>
</head>
<body>
	<h1>HI ${userInfo.userName}</h1>
	<h2>Send Result to Your Email</h2>
	
	<form:form action="process-email" method="get" modelAttribute="emailDTO">
	
		<label>Enter Your Email :</label>
		<form:input path="userEmail"/>
		<input type="submit" value="send">
	
	</form:form>
</body>
</html> 