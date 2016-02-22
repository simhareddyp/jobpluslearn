<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<h1>Search Registration</h1>
	<form:form method="POST" commandName="searchForm" action="search">

	<div>
			<form:label path="anyKeywords">Any of the Keywords<font
					color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="anyKeywords" htmlEscape="false"
				element="div" />
			<form:input path="anyKeywords" />
		</div>



		<div>
			<form:label path="allkeywords">All the Keywords<font
					color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="allkeywords" htmlEscape="false"
				element="div" />
			<form:input path="allkeywords" />
		</div>
		<div>

			<form:label path="excludingKeywords">All the Keywords<font
					color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="excludingKeywords" htmlEscape="false"
				element="div" />
			<form:input path="excludingKeywords" />
		</div>
		
			<div>
				<form:label path="workExpmin">Total Experience :
					</form:label>

	<form:errors cssClass="err"
						path="workExpmin" htmlEscape="false" element="div" /> <form:select
						path="workExpmin">
						<form:option label="-- Years-- " value="-1" />

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
					</form:select> <form:select path="workExpmax">
						<form:option label="-- Months-- " value="-1" />

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
					</form:select></div>

	

		
	<div>
				<form:label
						path="ctccurrency"> Annual Salary <font color='red'>*</font> :</form:label>
			<form:errors cssClass="err"
						path="ctccurrency" htmlEscape="false" element="div" /> <form:select
						path="ctccurrency">
						<form:option label="Select" value="-1" />
						<form:options items="${ctc}" itemLabel="ctccurrency"
							itemValue="ctccurrency" />
						<form:option label="Rs" value="1" size="1px" />
					</form:select> <form:select path="ctcmin">
						<form:option label="Min Sal" value="-1" />
						<form:option label="1" value="2" size="6px" />
					</form:select> <form:select path="ctcmax">
						<form:option label="Max Sal" value="-1" />
						<form:option label="1000" value="3" size="6px" />
					</form:select>

			</div>


		<div>
			<form:label path="cityName"> Location of Training:<font
					color='red'>*</font>
			</form:label>
			<form:errors cssClass="err" path="cityName" htmlEscape="false"
				element="div" />
			<form:select path="cityName" id="cityName">
				<form:option label="-- Select one --" value="-1" />


				<form:options items="${citiesList}" itemLabel="cityNm"
					itemValue="cityNm" />
			</form:select>
		</div>
<div>
				<form:label
						path="industryDetailsId">Industry  <font color='red'>*</font> :</form:label>

		<form:errors cssClass="err"
						htmlEscape="false" path="industryDetailsId" element="div" /> <form:select
						path="industryDetailsId">
						<form:option label="-- Select Industry --" value="-1" />
						<form:options items="${industryDetailsList}"
							itemLabel="industryType" itemValue="industryDetailsId" />


					</form:select></div>

		

			<div>
			<form:label
						path="functionalDetailsId">Functional Area <font
							color='red'>*</font> :</form:label>

			<form:errors cssClass="err"
						htmlEscape="false" path="functionalDetailsId" element="div" /> <form:select
						path="functionalDetailsId">
						<form:option label="-- Select functional --" value="-1" />
						<form:options items="${functionalList}" itemLabel="functionalName"
							itemValue="functionalDetailsId" />
					</form:select>

			

		</div>



		<div>
			<form:label path="employers"> Training Institute Name<font
					color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="employers" htmlEscape="false"
				element="div" />
			<form:input path="employers" />
		</div>


		<div>
			<form:label path="excludeemployers"> About Training Institute<font
					color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="excludeemployers" htmlEscape="false"
				element="div" />
			<form:input path="excludeemployers" />
		</div>

		<div>
			<form:label path="designation"> Website<font color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="designation" htmlEscape="false"
				element="div" />
			<form:input path="designation" />
		</div>
		
		
		<div >
						
				<form:label path="description">Specify PG Qualification <font
							color='red'>*</font> :</form:label>

			<form:errors cssClass="err"
						htmlEscape="false" path="description" element="div" /> <form:input
						path="description" />
		</div>

		<div>
			<form:label path="instituteName"> Institute Name<font
					color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="instituteName" htmlEscape="false"
				element="div" />
			<form:input path="instituteName" />
		</div>

<div >
						
				<form:label path="description">Specify PG Qualification <font
							color='red'>*</font> :</form:label>

			<form:errors cssClass="err"
						htmlEscape="false" path="description" element="div" /> <form:input
						path="description" />
		</div>

		<div>
			<form:label path="instituteName"> Institute Name<font
					color='red'>*</font>
			</form:label>

			<form:errors cssClass="err" path="instituteName" htmlEscape="false"
				element="div" />
			<form:input path="instituteName" />
		</div>

<div>
			<form:label path="category">Select a Category:<font
					color='red'>*</font> :</form:label>
			<form:errors cssClass="err" path="category" htmlEscape="false"
				element="div" />
			<form:select path="category">

				<form:option label="-- select-- " value="-1" />
			</form:select>
		</div>


	
		


		<div>
			<input type="submit" value="Register"
				style="height: 40px; width: 150px" />
		</div>




	</form:form>
	<form:form method="GET" commandName="clilogoutAction"
		action="clientloginpage">
		<input type="submit" value="Logout" style="height: 40px; width: 150px" />
	</form:form>
</body>
</html>