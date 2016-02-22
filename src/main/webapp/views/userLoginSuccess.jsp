<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Logged in</title>

</head>
<body>

	<form:form method="POST" commandName="userpostlogin"
		action="userpostlogin">

		<input type="submit" value="Edit User Page"
			style="height: 40px; width: 150px" />
	</form:form>
	<form:form method="GET" commandName="logoutAction"
		action="logoutAction">
		<input type="submit" value="Logout" style="height: 40px; width: 150px" />
	</form:form>
	<p>successfully logged in..</p>


</body>
</html>