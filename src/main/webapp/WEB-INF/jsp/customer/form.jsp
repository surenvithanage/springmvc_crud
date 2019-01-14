<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:url value="/customer/save" var="saveURL"></spring:url>
	<form:form action="${saveURL}" method="POST"
		modelAttribute="customerForm">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Firstname : </td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td>Lastname : </td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td>Gender : </td>
				<td>
					<form:radiobutton path="gender" value="Mail"/>Male
					<form:radiobutton path="gender" value="Female"/>Female
				</td>
			</tr>
			<tr>
				<td>Address : </td>
				<td><form:input path="address" rows="3"/></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Save</button></td>td>
			</tr>
		</table>
	</form:form>
</body>
</html>