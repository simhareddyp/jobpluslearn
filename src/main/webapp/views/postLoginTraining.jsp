<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" commandName="trainingForm" action="trainingcom">
		<div>
			<div>
				<form:label path="searchTraining">City :</form:label>
				<form:errors cssClass="err" htmlEscape="false" path="searchTraining"
					element="div" />
				<form:input path="searchTraining" />
			</div>
			<div>
			<p> This training is not available, you can try the following....</p>
			</div>
			<div>
					<form:label path="trainingName">Training Name :</form:label>
					<form:errors cssClass="err" path="trainingName" htmlEscape="false"
						element="div" />
					<form:input path="trainingName" />
				</div>
				<div>
					<form:label path="trainingWebsite">Training Website :</form:label>
					<form:errors cssClass="err" path="trainingWebsite" htmlEscape="false"
						element="div" />
					<form:input path="trainingWebsite" />
				</div>
			<div>
					<form:label path="trainingAddress">Training Address :</form:label>
					<form:errors cssClass="err" path="trainingAddress" htmlEscape="false"
						element="div" />
					<form:input path="trainingAddress" />
				</div>
			<div>
				<form:input type="submit" value="Apply" align="middle"
					style="height: 40px; width: 150px" path="" />
			</div>
			<div>
				<form:label path="requestTraining">Request for a Training :</form:label>
				<form:errors cssClass="err" htmlEscape="false" path="requestTraining"
					element="div" />
				<form:input path="requestTraining" />
			</div>
			<div>
				<form:input type="submit" value="Send" align="middle"
					style="height: 40px; width: 150px" path="" />
			</div>
		</div>
	</form:form>
</body>
</html>