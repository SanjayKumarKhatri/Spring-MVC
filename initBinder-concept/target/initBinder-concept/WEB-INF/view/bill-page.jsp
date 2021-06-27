<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Page</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>
</head>
<body>
	<h1 align="center">Bill</h1>
	<hr />

	<form:form action="process-bill" method="get" modelAttribute="billDTO">

		<div align="center">
			Credit Card :
			<form:input path="creditCard" />
			<form:errors path="creditCard" cssClass="error" />

			<br>
			<br> Amount :
			<form:input path="amount" />
			<form:errors path="amount" cssClass="error" />

			<br>
			<br> Currency :
			<form:input path="currency" />
			<form:errors path="currency" cssClass="error" />

			<br>
			<br> Date :
			<form:input path="date" />
			<form:errors path="date" cssClass="error" />

			<br>
			<br> <input type="submit" value="Pay Bill">
		</div>
	</form:form>
</body>
</html>