<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPL - Post Login Page 3rd Tab</title>
<spring:url value="/styles/NewUser.css" var="NewUser" />
<spring:url value="/styles/jquery-ui.css" var="jqueryuiCss" />
<spring:url value="/scripts/jquery-1.10.2.js" var="jqueryJs" />
<spring:url value="/scripts/jquery-ui.js" var="jqueryuiJs" />
<spring:url value="/scripts/jpl-date.js" var="jpldateJs" />
<spring:url value="/scripts/jpl-postloginpro.js" var="jplpostloginproJs" />

<spring:url value="/scripts/jquery.min.js" var="jqueryuiminJs" />
<spring:url value="/scripts/jquery-ui.min.js" var="jpljueryuiminJs" />
<spring:url value="/scripts/jpl.monthpicker.js" var="jplmonthpickJs" />

<link href="${NewUser}" rel="stylesheet" />
<link href="${jqueryuiCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${jqueryuiJs}"></script>
<script src="${jpldateJs}"></script>
<script src="${jplpostloginproJs}"></script>

<script src="${jqueryuiminJs}"></script>
<script src="${jpljueryuiminJs}"></script>
<script src="${jplmonthpickJs}"></script>
<style>
input.err {
	background-color: white
}

.err {
	color: red
}
</style>
<script>
	$(function() {

		$("#search")

		.change(

		function() {
			if ($("#search").val() != -1) {
				$('#target').attr('action', 'search');

				$("#target").submit();
			}

		});

	});
</script>
</head>
<body onload='nofunction()'>
	<fieldset id="msform">
		<form:form id="target" method="POST" commandName="postloginproForm"	action="postloginpro">
			<form:hidden id="serviceflag" path="isService" value="N" />
			<form:hidden id="employerName" path="employerName" />

			<h1 class="fs-title">Post Login Page</h1>
			<h3>Professional Details and Employment Details</h3>

			<form:hidden path="useremail" />

			<div>
				<div class="wrapper">
					<form:label path="domain">Domain :</form:label>
				</div>
				<div>
					
					<form:select path="domain" class="my_select">
						<form:option label="-- Select domain -- " value="-1" />

						<form:option label="Accounting" value="Accounting" />
						<form:option label="Adventure" value="1" />
						<form:option label="Apparel" value="2" />
						<form:option label="Apps" value="3" />
						<form:option label="Art" value="4" />
						<form:option label="Automotive" value="5" />
						<form:option label="Beauty" value="6" />
						<form:option label="Construction" value="7" />
						<form:option label="Consulting" value="8" />
						<form:option label="Design" value="9" />
						<form:option label="Development" value="10" />
						<form:option label="Entertainment" value="11" />
					</form:select>
					<form:errors cssClass="err" path="domain" htmlEscape="false" />
				</div>
			</div>
			<div>
				<div class="wrapper">
					<form:label path="addDomain"> Add Domain :</form:label>
				</div>
				<div>
					
					<form:input path="addDomain" />
					<form:errors cssClass="err" path="addDomain" htmlEscape="false" />
				</div>
			</div>
			<div>
				<div class="wrapper">
					<form:label path="">Serving Notice Period</form:label>
				</div>
				<div>
					<form:radiobutton path="noticePeriod" value="1"	onclick="yesfunction()" />Yes               
					<form:radiobutton path="noticePeriod" value="2" checked="checked" onclick="nofunction()" />	No
				</div>
			</div>
			

			<div id="service">

				<div>
					<div class="wrapper">
						<form:label path="availableDate">Available Date :</form:label>
					</div>
					<div>
						
						<input name="availableDate" id="demo-3" type="text"	onclick="pickcal()" />
						<input type="button" class="calendar_btn" value="..." id="demo-3-button" onclick="pickcal()">
						<form:errors cssClass="err" path="availableDate" htmlEscape="false" />
					</div>

				</div>
				<div>
					<div class="wrapper">
						<form:label path="offers">Offers in Hand :
					</form:label>
						
						<form:select path="offers" class="my_select">
							<form:option label="-- Select Years -- " value="-1" />

							<form:option label="1" value="1" />
							<form:option label="2" value="2" />
							<form:option label="3" value="3" />
							<form:option label="1" value="1" />
							<form:option label="4" value="4" />
							<form:option label="5" value="5" />
						</form:select>
						<form:errors cssClass="err" path="offers" htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="ctcOfferedLakhs">CTC Offered :
					</form:label>
						<form:errors cssClass="err" path="ctcOfferedLakhs"
							htmlEscape="false" />
						<form:select path="ctcOfferedLakhs" class="my_select">
							<form:option label="-- Select Lakhs -- " value="-1" />
							<form:option label="1" value="1" />
							<form:option label="2" value="2" />
							<form:option label="3" value="3" />
							<form:option label="4" value="4" />
							<form:option label="5" value="5" />

						</form:select>
						<form:select path="ctcOfferedThousands" class="my_select">
							<form:option label="-- Select Thousands -- " value="-1" />
							<form:option label="1000" value="1" />
							<form:option label="2000" value="2" />
							<form:option label="3000" value="3" />
							<form:option label="4000" value="4" />
							<form:option label="5000" value="5" />

						</form:select>
					</div>
				</div>
			</div>
			<div>
					<div class="wrapper">
						<form:label path="expectedCtcLakhs">Expected CTC :	</form:label>
					</div>
					<div>
								<form:errors cssClass="err" path="expectedCtcLakhs"	htmlEscape="false" />
								<form:select path="expectedCtcLakhs" class="my_select">
									<form:option label="-- Select Lakhs -- " value="-1" />
									<form:option label="1" value="1" />
									<form:option label="2" value="2" />
									<form:option label="3" value="3" />
									<form:option label="4" value="4" />
									<form:option label="5" value="5" />
		
								</form:select>
					</div>	
			</div>
			<div>		
					<div>
								<form:select path="expectedCtcThousands" class="my_select">
									<form:option label="-- Select Thousands -- " value="-1" />
									<form:option label="1000" value="1" />
									<form:option label="2000" value="2" />
									<form:option label="3000" value="3" />
									<form:option label="4000" value="4" />
									<form:option label="5000" value="5" />
	
							</form:select>
					</div>
			</div>	
				
				<div>
					<div class="wrapper">
						<form:label path="titleId">Expected Title :</form:label>
					</div>
					<div>	
						<form:errors cssClass="err" htmlEscape="false" path="titleId" />
						<form:select path="titleId" class="my_select">
							<form:option label="-- Select Title--" value="-1" />
							<form:options items="${titlesList}" itemLabel="titleName"
								itemValue="titleId" />
						</form:select>
					</div>
				</div>
			
			<h3>Employment Details</h3>

			<div id="emp">

				<div>
					<div class="wrapper">
						<form:label path="employerName">Employer Name :</form:label>
					</div>
					<div>
						<form:errors cssClass="err" htmlEscape="false" path="employerName" />
						<form:input path="employerName" />
					</div>
					<div class="wrapper">
						<form:radiobutton path="employerType" value="1" />
						Current employer
						<form:radiobutton path="employerType" value="2" checked="checked" />
						Previous employer
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="durationMonthsFrom">Duration :
					</form:label>
						<form:errors cssClass="err" path="durationMonthsFrom"
							htmlEscape="false" />
						<form:select path="durationMonthsFrom" class="my_select">
							<form:option label="-- Select Months -- " value="-1" />

							<form:option label="0" value="0" />
							<form:option label="1" value="1" />
							<form:option label="2" value="2" />
							<form:option label="3" value="3" />
							<form:option label="1" value="1" />
							<form:option label="4" value="4" />
							<form:option label="5" value="5" />
							<form:option label="6" value="6" />
							<form:option label="7" value="7" />
							<form:option label="8" value="8" />
							<form:option label="9" value="9" />
							<form:option label="10" value="10" />
							<form:option label="11" value="11" />
							<form:option label="12" value="12" />
						</form:select>
						<form:select path="durationYearsFrom" class="my_select">
							<form:option label="-- Select Years -- " value="-1" />

							<form:option label="0" value="0" />
							<form:option label="1" value="1" />
							<form:option label="2" value="2" />
							<form:option label="3" value="3" />
							<form:option label="4" value="4" />
							<form:option label="5" value="5" />
							<form:option label="6" value="6" />
							<form:option label="7" value="7" />
							<form:option label="8" value="8" />
							<form:option label="9" value="9" />
							<form:option label="10" value="10" />
							<form:option label="11" value="11" />
							<form:option label="12" value="12" />
							<form:option label="13" value="13" />
							<form:option label="14" value="14" />
							<form:option label="15" value="15" />
							<form:option label="16" value="16" />
							<form:option label="17" value="17" />
							<form:option label="18" value="18" />
							<form:option label="19" value="19" />
							<form:option label="20" value="20" />
							<form:option label="21" value="21" />
							<form:option label="22" value="22" />
							<form:option label="23" value="23" />
							<form:option label="24" value="24" />
							<form:option label="25" value="25" />
							<form:option label="26" value="26" />
							<form:option label="27" value="27" />
							<form:option label="28" value="28" />
							<form:option label="29" value="29" />
							<form:option label="30" value="30" />
							<form:option label="31" value="31" />
							<form:option label="32" value="32" />
							<form:option label="33" value="33" />
							<form:option label="34" value="34" />
							<form:option label="35" value="35" />
							<form:option label="36" value="36" />
							<form:option label="37" value="37" />
							<form:option label="38" value="38" />
							<form:option label="39" value="39" />
							<form:option label="40" value="40" />
						</form:select>
						To
						<form:select path="durationMonthsTo" class="my_select">
							<form:option label="-- Select Months -- " value="-1" />

							<form:option label="0" value="0" />
							<form:option label="1" value="1" />
							<form:option label="2" value="2" />
							<form:option label="3" value="3" />
							<form:option label="4" value="4" />
							<form:option label="5" value="5" />
							<form:option label="6" value="6" />
							<form:option label="7" value="7" />
							<form:option label="8" value="8" />
							<form:option label="9" value="9" />
							<form:option label="10" value="10" />
							<form:option label="11" value="11" />
							<form:option label="12" value="12" />
						</form:select>
						<form:select path="durationYearsTo" class="my_select">
							<form:option label="-- Select Years -- " value="-1" />

							<form:option label="0" value="0" />
							<form:option label="1" value="1" />
							<form:option label="2" value="2" />
							<form:option label="3" value="3" />
							<form:option label="4" value="4" />
							<form:option label="5" value="5" />
							<form:option label="6" value="6" />
							<form:option label="7" value="7" />
							<form:option label="8" value="8" />
							<form:option label="9" value="9" />
							<form:option label="10" value="10" />
							<form:option label="11" value="11" />
							<form:option label="12" value="12" />
							<form:option label="13" value="13" />
							<form:option label="14" value="14" />
							<form:option label="15" value="15" />
							<form:option label="16" value="16" />
							<form:option label="17" value="17" />
							<form:option label="18" value="18" />
							<form:option label="19" value="19" />
							<form:option label="20" value="20" />
							<form:option label="21" value="21" />
							<form:option label="22" value="22" />
							<form:option label="23" value="23" />
							<form:option label="24" value="24" />
							<form:option label="25" value="25" />
							<form:option label="26" value="26" />
							<form:option label="27" value="27" />
							<form:option label="28" value="28" />
							<form:option label="29" value="29" />
							<form:option label="30" value="30" />
							<form:option label="31" value="31" />
							<form:option label="32" value="32" />
							<form:option label="33" value="33" />
							<form:option label="34" value="34" />
							<form:option label="35" value="35" />
							<form:option label="36" value="36" />
							<form:option label="37" value="37" />
							<form:option label="38" value="38" />
							<form:option label="39" value="39" />
							<form:option label="40" value="40" />
						</form:select>
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="designation">Designation :</form:label>
						<form:errors cssClass="err" path="designation" htmlEscape="false" />
						<form:input cssErrorClass="err" path="designation" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="achievements">Achievements :</form:label>
						<form:errors cssClass="err" path="achievements" htmlEscape="false" />
						<form:textarea cssErrorClass="err" path="achievements" />
					</div>
				</div>
				<div>
					<div>
						<input type="button" value="Add Another" id="empsearch"
							onclick='myempfunction()' />
					</div>
				</div>
			</div>
			<div id="emplist">
				<div>
					<font size="3">Employer Name</font>
					<font size="3">Current/Previous</font>
					<font size="3">Duration</font>
					<font size="3">Designation</font>
				</div>
			</div>
			<div>

				<div>
					<div>
						<h3>Communication Settings</h3>
					</div>
				</div>
				<div>
					<div >
						<form:checkbox value="sms"
							onclick='OnChangeCheckbox(this), enable_text(this.checked)'
							id="myCheck" path="sms" />
						Send SMS for criteria selected below
					</div>
				</div>
				<div>
					<div >
						<form:checkbox value="email"
							onclick='OnChangeCheckbox1(this), enable_text(this.checked1)'
							id="myCheck1" path="email" />
						Send Email for criteria selected below
					</div>
				</div>
				<div>
					<div >
						<form:checkbox value="email"
							onclick='OnChangeCheckbox1(this), enable_text(this.checked1)'
							id="myCheck2" path="automatic" />
						Apply automatically for criteria selected below
					</div>
				</div>
				<div align="left">
					<form:checkbox value="email"
						onclick='OnChangeCheckbox1(this), enable_text(this.checked1)'
						id="myCheck3" path="exp" />
					Experience
				</div>
				<div>

					<div align="left">
						<form:checkbox value="email"
							onclick='OnChangeCheckbox1(this), enable_text(this.checked1)'
							id="myCheck4" path="key" />
						Key skills
						<form:radiobutton path="keyType" value="1" />
						Any One
						<form:radiobutton path="keyType" value="2" checked="checked" />
						All
					</div>
				</div>
				<div>
					<div align="left">
						<form:checkbox value="email"
							onclick='OnChangeCheckbox1(this), enable_text(this.checked1)'
							id="myCheck5" path="chedomain" />
						Domain
					</div>
				</div>
				<div>
					<div align="left">
						<form:checkbox value="email"
							onclick='OnChangeCheckbox1(this), enable_text(this.checked1)'
							id="myCheck6" path="role" />
						Title/Role
					</div>
				</div>
			</div>
			<div>
				<div>
					<div>
						<h3>Block companies</h3>
					</div>
					<div>
						<form:label path="CompanyDetailsDm.companyName">Name of The Company  <font
								color='red'>*</font> :</form:label>

						<form:errors cssClass="err" htmlEscape="false"
							path="CompanyDetailsDm.companyName" element="div" />
						<form:input path="CompanyDetailsDm.companyName" />
					</div>
				</div>
			</div>
			<div>

				<div>
					<div>
						<h3>Visibility Settings</h3>
					</div>
				</div>
				<div>
					<div>
						<form:radiobutton path="visibilityType" value="1"
							checked="checked" />
						Actively Looking
					</div>
				</div>
				<div>
					<div>
						<form:radiobutton path="visibilityType" value="1" />
						Not Actively Looking
					</div>
				</div>
				<div>
					<div>
						<form:radiobutton path="visibilityType" value="1" />
						Not Visible
					</div>
				</div>
				<div>
					<div>
						<input type="submit" value="Save"
							style="height: 40px; width: 150px" /> <A
							href="http://localhost:8080/jobpluslearn/user/userpostlogin">
							<input type="button" value="Cancel"
							style="height: 40px; width: 150px" />
						</A>
					</div>
				</div>
			</div>
		</form:form>
		<form:form method="GET" commandName="logoutAction"
			action="userloginpage">
			<input type="submit" value="Logout"
				style="height: 40px; width: 150px" />
		</form:form>
	</fieldset>
</body>
</html>