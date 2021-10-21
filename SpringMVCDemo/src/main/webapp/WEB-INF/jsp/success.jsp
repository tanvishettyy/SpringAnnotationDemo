<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
	<h2> Employee Created</h2>
	Employee <%=request.getParameter("empName") %> created with ID :<%=request.getParameter("empID") %> Phone: <%=request.getParameter("empPhoneNum") %> Experience: <%=request.getParameter("empExperience") %>
</body>
</html>