<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error{


}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h2>${HeaderStatus}</h2>
<title>Add Employee</title>
</head>
<body>
	<!-- <form action="add">
		Enter name <input type="text" name="ename"/>
		Enter ID <input type="text" name="eid"/>
		Enter phone <input type="text" name="empPhone"/>
		<input type="submit" value="Create Employee"/>
	</form> -->
	
	<springform:form action="add" modelAttribute="employee" method="POST">
	<%-- <springform:errors path="errors" cssClass="error"/> --%>
	<springform:errors path="*" cssClass="error"/>
	<br><br>
	<springform:label path="empName">Employee Name</springform:label>
	<springform:input path="empName" type="text"/>
	<br><br>
	<springform:label path="empPhoneNum">Employee Phone</springform:label>
	<springform:input path="empPhoneNum" type="text"/>
	<br><br>
	<springform:label path="empID">Employee ID</springform:label>
	<springform:input path="empID" type="text"/>
	<br><br>
	<springform:label path="dateOfBirth">Employee DOB</springform:label>
	<springform:input path="dateOfBirth" type="date"/>
	<br><br>
	<springform:label path="empExperience">Employee experience</springform:label>
	<springform:input path="empExperience"/>
	<br><br>
	<input type="submit" value="Submit"/>
	</springform:form>
	
</body>
</html>