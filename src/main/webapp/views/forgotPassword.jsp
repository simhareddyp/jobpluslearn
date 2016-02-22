<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
<form:form method="GET" commandName="forgotPasswordForm"
		action="forgotPassword">
		<table cellpadding="4" cellspacing="4" border="0">
			<col width="200" />
			<col width="150" />
			<col width="200" />
			<col width="150" />

			<tr>
				<td align="right" valign="bottom"><form:label path="OTP">Enter OTP :
					</form:label></td>
				<td colspan="3"><form:input cssErrorClass="err" path="OTP" /></td>
			</tr>
			</table>
			</form:form>
			<A href="http://localhost:8080/jobpluslearn/user/OTP"><input type="button" value="Submit"
					style="height: 40px; width: 150px" /></A>
</body>
</html>