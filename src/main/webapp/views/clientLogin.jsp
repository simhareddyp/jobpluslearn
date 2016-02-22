<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>JPL - Client Registration</title>

<spring:url value="/styles/ClientLogin.css" var="ClientLogin" />
<spring:url value="/scripts/jquery-1.10.2.js" var="jqueryJs" />
<spring:url value="/scripts/jquery-ui.js" var="jqueryuiJs" />


 <link href="${ClientLogin}" rel="stylesheet" />

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
			<form:form method="POST" commandName="clientloginForm"	action="cliauthenticate">
								
						
				<div class="input_wrap">	
						<form:label path="emailId">Email Id <font color='red'>*</font> :</form:label>
						
						<form:errors cssClass="err" path="emailId"	htmlEscape="false" element="div" /> 
						<form:input type="email"	 placeholder="abc@sample.com" title="Email Id" cssErrorClass="err" path="emailId" />
				</div>	
					
					<br/>
				<div class="input_wrap">
					<br/>
				
						<form:label path="password"> Password <font	color='red'>*</font> :</form:label>
				
						<form:errors cssClass="err"	path="password" htmlEscape="false" element="div" /> 
						<form:password placeholder="Password" title="Password" path="password" />
				</div>
					
				
				<div>
					<br/>
							<input type="submit"  value="Submit" class="button_gp"/>
							
							<input type="button"  value="Cancel" class="button_gp" onclick="window.location.href='http://localhost:8080/jobpluslearn'"/>
							<br/><br/><br/>
					<div class="login-links">
						    <a href="http://localhost:8080/jobpluslearn/client/clinew">Register</a>
						    <b> . </b>
						    <a href="http://localhost:8080/jobpluslearn/client/cliforgotPassword">Forgot Password</a>
	  				</div>
				</div>			
					
				
			</form:form>
		</div>
	</div>
</body>
</html>