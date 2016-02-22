<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPL - User Registration</title>

<spring:url value="/scripts/jquery-1.10.2.js" var="jqueryJs" />
<spring:url value="/scripts/jquery-ui.js" var="jqueryuiJs" />
<spring:url value="/styles/UserLogin.css" var="UserLogin" />

<link href="${UserLogin}" rel="stylesheet" />

<script src="${jqueryJs}"></script>
<script src="${jqueryuiJs}"></script>

<style>

</style>
</head>
<body>
	<div class="login-card">
			<div>
				<h1>Log In</h1> 
				<hr><br/>
			</div>
	
		<div>
			<form:form method="POST" commandName="userloginForm" action="authenticate">
				

					
						<div class="input_wrap">
							<form:label path="emailId">Email Id <font color='red'>*</font> :</form:label>
							<form:errors cssClass="err" path="emailId" htmlEscape="false" element="div" />
							<form:input cssErrorClass="err" path="emailId" placeholder="abc@sample.com" title="Email Id"/>
						</div>
					
						<br/>
					
						<div class="input_wrap">
						<br/>
							<form:label path="password"> Password <font	color='red'>*</font> :</form:label>
			
							<form:errors cssClass="err" path="password" htmlEscape="false" element="div" />
							<form:password path="password" placeholder="Password" title="Password"/>
						</div>
				
					
					
					<div>
						<br/>
							<input type="submit" value="Submit"  class="button_gp"/>
							<input type="button" value="Cancel" class="button_gp" onclick="window.location.href='http://localhost:8080/jobpluslearn'" />
						<br/><br/><br/>
						
						
					
					
						<div class="login-links">
							<A href="http://localhost:8080/jobpluslearn/user/usernew"> Register</A>
							<b> . </b>
							<A href="http://localhost:8080/jobpluslearn/user/userforgotPassword">Forgot	Password</A>
						
						</div>
					</div>	
					
				
			</form:form>
		</div>
	</div>
</body>


</html>