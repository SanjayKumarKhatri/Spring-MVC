<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Your registraction is successfull!!</h1>
	<h2>The detail entered you are : </h2>
	
	Name :	${userReg.name} <br/>
	User Name :	${userReg.username} <br/>
	Password :	${userReg.password} <br/>
	Country Name :	${userReg.countryName} <br/>
	Hobbies :	
	<c:forEach var="temp" items="${userReg.hobbies}">
		${temp}
	</c:forEach> <br/>	
	Gender :	${userReg.gender} <br/>
</body>
</html>