<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registraction Page</title>
</head>
<body>
	<h1 align="center">Please Register Here</h1>
	<hr/>
	
	<form:form action="registraction-success" method="get" modelAttribute="userReg">
	
	<div align="center">
	    Name : <form:input path="name"/>
		
		<br><br>
		
		User Name : <form:input path="username"/>
		
		<br><br>
		
		Password : <form:password path="password"/>
		
		<br><br>
		
		Country Name : <form:select path="countryName">
		
			<form:option value="Pak" label="Pakistan"></form:option>
			<form:option value="Ind" label="India"></form:option>
			<form:option value="Us" label="United State"></form:option>
			<form:option value="Turk" label="Turkey"></form:option>
		</form:select>
		
		<br><br>
		
		Hobbies :
		Cricket<form:checkbox path="hobbies" value="cricket"/>
		Reading<form:checkbox path="hobbies" value="reading"/>
		Traveling<form:checkbox path="hobbies" value="travel"/>
		Programming<form:checkbox path="hobbies" value="programming"/>
		
		<br><br>
		
		 Gender :
		 Male<form:radiobutton path="gender" value="male"/>
		 Female<form:radiobutton path="gender" value="female"/>
		 
		 <br><br>
		 
		 <input type="submit" value="register"/>
		 
	
	</div>
	</form:form>		
			
</body>
</html>