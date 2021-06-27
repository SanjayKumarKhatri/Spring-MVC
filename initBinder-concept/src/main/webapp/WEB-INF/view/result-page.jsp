<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>
	<h1 align="Center">Bill</h1>
	<hr/>
	
	<p> Credit Card Number : ${billDTO.creditCard} </p>
	<p> Amount : ${billDTO.amount} </p>
	<p> Currency : ${billDTO.currency} </p>
	<p> Date : ${billDTO.date} </p>
	
	
</body>
</html>