<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<spring:url value="/styles/jquery-ui.css" var="jqueryuiCss" />
<spring:url value="/scripts/jquery.min.js" var="jqueryuiminJs" />
<spring:url value="/scripts/jquery-ui.min.js" var="jpljueryuiminJs" />
<spring:url value="/scripts/jpl.monthpicker.js" var="jplmonthpickJs" />
<spring:url value="/scripts/jpl-training.js" var="jpltrainingJs" />
<jsp:include page="navigation.jsp"></jsp:include>
<spring:url value="/styles/bootstrap.css" var="bootstrapCss" />
<spring:url value="/scripts/bootstrap.min.js" var="bootstrapJS" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${jqueryuiCss}" rel="stylesheet" />
<script src="${jqueryuiminJs}"></script>
<script src="${jpljueryuiminJs}"></script>
<script src="${jplmonthpickJs}"></script>
<script src="${jpltrainingJs}"></script>
<script src="${bootstrapJS}"></script>




</head>
<body>
	<h1>Training Requirement</h1>
	<form:form method="POST" commandName="trainingForm" action="training">
		<div class="container">
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="training">Select a training for Posting:<font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="training" htmlEscape="false"
						element="div" />
					<form:select path="training">

						<form:option label="-- select-- " value="-1" />
					</form:select>
				</div>
			</div>


			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="trainingName">Name of the training<font
							color='red'>*</font>
					</form:label>
				</div>
				<form:errors cssClass="err" path="trainingName" htmlEscape="false"
					element="div" />
				<div class="col-xs-3">
					<form:input path="trainingName" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">

					<form:label path="trainingDescription">Training Description <font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<textarea> </textarea>
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="startdate">Start Date :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="startdate" htmlEscape="false"
						element="div" />
					<input name="startdate" id="demo-5" type="text"
						onclick="pickcal2()" /><input type="button" value="..."
						id="demo-5-button" onclick="pickcal2()"><small></small>
				</div>
				<div class="col-xs-3">
					<form:label path="enddate">End Date :</form:label>

				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="enddate" htmlEscape="false"
						element="div" />
					<input name="enddate" id="demo-6" type="text" onclick="pickcal3()" /><input
						type="button" value="..." id="demo-6-button" onclick="pickcal3()"><small></small>
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="keywords"> Keywords <font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="keywords" htmlEscape="false"
						element="div" />
					<form:input path="keywords" />
				</div>
			</div>


			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="cityName"> Location of Training:<font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="cityName" htmlEscape="false"
						element="div" />
					<form:select path="cityName" id="cityName">
						<form:option label="-- Select one --" value="-1" />


						<form:options items="${citiesList}" itemLabel="cityNm"
							itemValue="cityNm" />
					</form:select>
				</div>
			</div>



			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="instituteName"> Training Institute Name<font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">

					<form:errors cssClass="err" path="instituteName" htmlEscape="false"
						element="div" />
					<form:input path="instituteName" />
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="aboutInstitute"> About Training Institute<font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="aboutInstitute"
						htmlEscape="false" element="div" />
					<form:input path="aboutInstitute" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="website"> Website<font color='red'>*</font>
					</form:label>
				</div>

				<div class="col-xs-3">
					<form:errors cssClass="err" path="website" htmlEscape="false"
						element="div" />
					<form:input path="website" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="contactPerson"> Contact Person<font
							color='red'>*</font>
					</form:label>
				</div>

				<div class="col-xs-3">
					<form:errors cssClass="err" path="contactPerson" htmlEscape="false"
						element="div" />
					<form:input path="contactPerson" />
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">

					<form:label path="address">Address<font color='red'>*</font> :</form:label>
				</div>

				<div class="col-xs-3">
					<textarea> </textarea>

				</div>

				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-3">
						<form:label path="contactNumber"> Contact Number<font
								color='red'>*</font>
						</form:label>
					</div>

					<div class="col-xs-3">
						<form:errors cssClass="err" path="contactNumber"
							htmlEscape="false" element="div" />
						<form:input path="contactNumber" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-3">
						<form:label path="referenceId"> Reference Id<font
								color='red'>*</font>
						</form:label>
					</div>

					<div class="col-xs-3">
						<form:errors cssClass="err" path="referenceId" htmlEscape="false"
							element="div" />
						<form:input path="referenceId" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-3">
						<form:label path="cost"> Cost <font color='red'>*</font>
						</form:label>
					</div>

					<div class="col-xs-3">
						<form:errors cssClass="err" path="cost" htmlEscape="false"
							element="div" />
						<form:input path="cost" />
					</div>

				</div>

				<div>
					<input type="submit" value="Register"
						style="height: 40px; width: 150px" />
				</div>


			</div>
	</form:form>
	<%-- <form:form method="GET" commandName="clilogoutAction"
		action="clientloginpage">
		<input type="submit" value="Logout" style="height: 40px; width: 150px" />

	</form:form> --%>
</body>
</html>