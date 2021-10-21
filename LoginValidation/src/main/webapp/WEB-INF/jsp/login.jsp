<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
		<springform:form action="login" modelAttribute="employee">
		<springform:errors path="*" cssClass="error"/>
	<br><br>
	<springform:label path="empName">Enter Employee Name</springform:label>
	<springform:input path="empName" type="text"/>
	<br><br>
	<springform:label path="empId">Enter Employee ID</springform:label>
	<springform:input path="empId" type="text"/>
	<br><br>
		<input type="submit" value="Submit"/>
	</springform:form>
	
	</body>
</html>