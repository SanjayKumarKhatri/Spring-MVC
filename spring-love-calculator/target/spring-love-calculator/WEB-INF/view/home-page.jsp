<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<script type="text/javascript">

	function validateUserName(){
	var userName =	document.getElementById('yn').value;
	if (userName.length < 1) {
		alert("your name should have al least one character");
		return false;
		
	} else {
		return true;
	}
		
	}

</script>

</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr/>
	
	<form:form action="process-homepage" method="get" modelAttribute="userInfo">
		<div align="center">
			<p>
				<label for="yn">Your Name : </label>
				<form:input id="yn" path="userName"/>
			</p>
			
			<p>
				<label for="cn">Crush Name : </label>
				<form:input id="cn" path="crushName"/>
			</p>
			
			<input type="submit" value="Calculate">
		
		
		</div>
	
	
	</form:form>
	
	
</body>
</html>