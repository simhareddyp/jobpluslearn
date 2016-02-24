<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>JPL - Job Posting Form</title>
<spring:url value="/styles/wickedpicker.css" var="wickedpickerCss" />
<spring:url value="/styles/previewForm.css" var="previewFormCss" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<spring:url value="/styles/bootstrap.css" var="bootstrapCss" />
<spring:url value="/scripts/jquery.min.js" var="jqueryJS" />
<spring:url value="/scripts/jquery-ui.min.js" var="jqueryuiJS" />
<spring:url value="/scripts/bootstrap.min.js" var="bootstrapJS" />
<spring:url value="/styles/smoothness.css" var="smoothnessCss" />
<spring:url value="/styles/full-width-pics.css" var="fullwidthpicsCss" />
<spring:url value="/styles/sol.css" var="solCss" />
<spring:url value="/scripts/sol.js" var="solJs" />

<jsp:include page="navigation.jsp"></jsp:include>
<spring:url value="/styles/NewUser.css" var="NewUser" />
<spring:url value="/scripts/jpl-jobposting.js" var="jpljobpostingJs" />
<spring:url value="/scripts/jquery.ui.datepicker.js"
	var="jqueryuidatepickerJs" />
<link href="${NewUser}" rel="stylesheet" />
<link href="${fullwidthpicsCss}" rel="stylesheet" />
<link href="${solCss}" rel="stylesheet" />

<link href="${smoothnessCss}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${previewFormCss}" rel="stylesheet" />
<link href="${wickedpickerCss}" rel="stylesheet" />
<script src="${jpljobpostingJs}"></script>

<script src="${jqueryJS}"></script>
<script src="${solJs}"></script>

<script src="${jqueryuiJS}"></script>
<script src="${bootstrapJS}"></script>
<spring:url value="/ckeditor/ckeditor.js" var="ckeditotJS" />
<spring:url value="/ckeditor/js/jpl-ckeditor.js" var="jplckeditotJS" />
<spring:url value="/ckeditor/css/jpl-ckeditor.css" var="jplckeditorCSS" />
<link href="${jplckeditorCSS}" rel="stylesheet" />
<script src="${ckeditotJS}"></script>
<script src="${jplckeditotJS}"></script>

<script src="${jqueryuidatepickerJs}"></script>
<script src="../scripts/nicEdit.js" type="text/javascript"></script>
<script src="../scripts/wickedpicker.js" type="text/javascript"></script>
<script>
	$(function() {
		$("#template").change(function() {
			alert('vkemvkev')
			if ($("#template").val() != -1) {
				$('#target').attr('action', 'template');
				// $("#jobname").attr("disabled", "disabled"); 
				$("#target").submit();
			}
		});
	});
</script>
<script>
	$(document).ready(function() {
		$('#target').previewForm();
	});
</script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<script type="text/javascript">
	function picker() {
		$('.timepicker').wickedpicker({
			twentyFour : false
		});
		$('.timepicker-two').wickedpicker({
			twentyFour : true
		});
	}
</script>
<script>
	initSample();
</script>
<script>
	var area1, area2;
	function toggleArea1() {
		if (!area1) {
			area1 = new nicEditor({
				fullPanel : true
			}).panelInstance('myArea1', {
				hasPanel : true
			});
		} else {
			area1.removeInstance('myArea1');
			area1 = null;
		}
	}
	function addArea2() {
		area2 = new nicEditor({
			fullPanel : true
		}).panelInstance('myArea2');
	}
	function removeArea2() {
		area2.removeInstance('myArea2');
	}
	bkLib.onDomLoaded(function() {
		toggleArea1();
	});
</script>
<SCRIPT TYPE="text/javascript">
	function popupform(myform) { //myform=document.getElementById("target")
		alert('Hi');
		if (!window.focus)
			return true;
		window.open('jobPostingPreview', 'Priview', 'height=200,width=400,scrollbars=yes');
		myform.target = windowname;
		return true;
	}
</SCRIPT>
<script>
	function valueChanged() {
		if ($('#chkPassport').is(":checked")) {
			$("#dvPassport").show();
			$("#txtPassportNumber").show()
		} else {
			$("#dvPassport").hide();
			$("#txtPassportNumber").hide()
		}
	}
	
	 
</script>
<script>
function displayOutput(){
	 $("#listemails").show();
	var emailId = $("#userInput").val();
	alert(emailId);
	$("#newEmails").val(emailId) ;
	$("#userInput").val("");
} 
      
    </script>
</head>
<body onload='emailfunction()'>
<input type="hidden" name="newjob" value=<%  %>/>
	<form:form id="target" method="POST" commandName="postForm"
		action="postingjob">

		<form:hidden id="responseflag" path="isResponse" value="N" />
		<form:hidden id="jobid" path="jobid" />
		
		<h1 class="fs-title">Job Posting Form - Hot Vacancy</h1>

		<h3>Job Details</h3>
		<div class="container">
			<div class="row">
				<div class="col-xs-3">
					<form:label path="template">Select Job to Autofill  <font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:select path="template" style="height: 32px;width:350px;">
						<form:option label="-- Select Template --" value="-1" />
						<form:options items="${templateList}" />
					</form:select>
					<form:errors cssClass="err" htmlEscape="false" path="template" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4">

					<label for="chkPassport"></label> <input type="checkbox"
						id="chkPassport" onclick="valueChanged()" /> <b>Do you want
						to save?</b>

				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3" id="dvPassport" style="display: none">

					<label> Job Name:</label>
				</div>
				<div class="col-xs-3" id="txtPassportNumber" style="display: none">
					<form:input type="text" path="jobname" />
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="jobTitle"> Job Title/Designation <font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:input path="jobTitle" />
					<form:errors cssClass="err" path="jobTitle" htmlEscape="false" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="numberofvacancies"> Number of Vacancies :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="numberofvacancies"
						htmlEscape="false" element="div" />
					<form:input path="numberofvacancies" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="jobDescription"> 	Job Description:<font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-6"
					style="width: 800px; height: 100px; margin-bottom: 145px;">
					<form:textarea path="jobDescription" id="editor1" />
				</div>
				<script>
					// Replace the <textarea id="editor1"> with a CKEditor
					// instance, using default configuration.
					CKEDITOR.replace('editor1');
				</script>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">

					<form:label path="keywords">	Keywords:<font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">
					<form:textarea path="keywords"
						placeholder="Use multiple words separated by commas"
						style="width: 400px;height:50px" />
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="workExpmin">Total Experience :</form:label>
				</div>
				<div class="col-xs-3">

					<form:errors cssClass="err" path="workExpmin" htmlEscape="false"
						element="div" />
					<form:select path="workExpmin" style="height: 32px">
						<form:option label="-- workExpmin-- " value="-1" />
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
				<div class="col-xs-3">
					<form:select path="workExpmax" style="height: 32px">
						<form:option label="-- workExpmax-- " value="-1" />
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
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="ctccurrency"> CTC <font color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-1">
					<form:errors cssClass="err" path="ctccurrency" htmlEscape="false"
						element="div" />
					<form:select path="ctccurrency" style="height: 32px">
						<form:option label="Select" value="-1" />
						<form:options items="${ctc}" itemLabel="ctccurrency"
							itemValue="ctccurrency" />
						<form:option label="Rs" value="1" size="1px" />
					</form:select>
				</div>
				<div class="col-xs-1">
					<form:select path="ctcmin" style="height: 32px">
						<form:option label="Min Sal" value="-1" />
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
						<form:option label="41" value="41" />
						<form:option label="42" value="42" />
						<form:option label="43" value="43" />
						<form:option label="44" value="44" />
						<form:option label="45" value="45" />
						<form:option label="46" value="46" />
						<form:option label="47" value="47" />
						<form:option label="48" value="48" />
						<form:option label="49" value="49" />
						<form:option label="50" value="50" />
					</form:select>
				</div>
				<div class="col-xs-1">
					<form:select path="ctcmax" style="height: 32px">
						<form:option label="Max Sal" value="-1" />
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
						<form:option label="41" value="41" />
						<form:option label="42" value="42" />
						<form:option label="43" value="43" />
						<form:option label="44" value="44" />
						<form:option label="45" value="45" />
						<form:option label="46" value="46" />
						<form:option label="47" value="47" />
						<form:option label="48" value="48" />
						<form:option label="49" value="49" />
						<form:option label="50" value="50" />
					</form:select>
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-4">
					<input type="checkbox" id="myCheck"><b>Hide salary from
						jobseekers</b>

				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="otherSalaryDetails">Other Salary Details :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="otherSalaryDetails"
						htmlEscape="false" />
					<form:input cssErrorClass="err" path="otherSalaryDetails" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="locationOfJob">Location(s) of Job :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="locationOfJob" htmlEscape="false" />
					<form:input cssErrorClass="err" path="locationOfJob" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="industryDetailsId">Industry  <font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" htmlEscape="false"
						path="industryDetailsId" element="div" />
					<form:select path="industryDetailsId" style="height: 32px">
						<form:option label="-- Select Industry --" value="-1" />
						<form:options items="${industryDetailsList}"
							itemLabel="industryType" itemValue="industryDetailsId" />
					</form:select>
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="functionalDetailsId">Functional Area <font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" htmlEscape="false"
						path="functionalDetailsId" element="div" />
					<form:select path="functionalDetailsId" style="height: 32px">
						<form:option label="-- Select functional --" value="-1" />
						<form:options items="${functionalList}" itemLabel="functionalName"
							itemValue="functionalDetailsId" />
					</form:select>
				</div>
			</div>
			<h3>Desired Candidate Profile</h3>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="levelId">Specify Qualification: <font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" htmlEscape="false" path="levelId" element="div"/>
					<form:input path="levelId" id="technologies" /> 
					<%-- <form:select path="levelId" style="height: 32px">
						<form:option label="-- Select qualification --" value="-1" />
						<form:options items="${levelList}" itemLabel="levelCode"
							itemValue="levelId" />
					</form:select>  --%>
				</div>
			</div>
			<%-- <div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="levelId">Specify Grduate Qualification: <font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" htmlEscape="false" path="levelId" />
					<form:input path="levelId" id="technologies" />
				</div>
			</div> --%>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="branchId">Branch <font color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" htmlEscape="false" path="branchId"
						element="div" />
					<form:select path="branchId" style="height: 32px;">
						<form:option label="-- Select Branch --" value="-1" />
						<form:options items="${branchesList}" itemLabel="description"
							itemValue="branchId" />
					</form:select>
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="branchId">Branch <font color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" htmlEscape="false" path="branchId" />
					<form:select path="branchId" style="height: 32px;">
						<form:option label="-- Select Branch --" value="-1" />
						<form:options items="${branchesList}" itemLabel="description"
							itemValue="branchId" />
					</form:select>
				</div>
			</div>
			<h3>Employer and Recruiter Details</h3>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="companyName">Company Name<font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="companyName" htmlEscape="false" />
					<form:input path="companyName" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="aboutCompany">About Company<font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="aboutCompany" htmlEscape="false" />
					<form:input path="aboutCompany" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="companyWebsite">Company Website :</form:label>
				</div>

				<div class="col-xs-3">
					<form:errors cssClass="err" path="companyWebsite"
						htmlEscape="false" />
					<form:input path="companyWebsite" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="contactPerson">Contact Person :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="contactPerson" htmlEscape="false" />
					<form:input path="contactPerson" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="address">Address :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="address" htmlEscape="false" />
					<form:input path="address" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-4">
					<input type="checkbox" id="myCheck"><b>Display My
						Company Name as Part of address</b>
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">

					<form:label path="contactNumber">Contact Number:</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="contactNumber" htmlEscape="false" />
					<form:input path="contactNumber" />
				</div>
			</div>
			<h3>Manage Response</h3>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="receiveResponseson">Receive Responses On: </form:label>
				</div>
				<div class="col-xs-3">
					<input type="radio" name="response" onclick="emailfunction()"
						value="1" id="ppp" /> Email and Response Manager
				</div>
				<div class="col-xs-3">
					<input type="radio" name="response" value="2" id="qqq" /> eApps
				</div>
				<div class="col-xs-3">
					<input type="radio" name="response" onclick="walkinfunction()"
						value="3" id="sss" />
					<p>walkin</p>
				</div>
			</div>
			<div id="emailresponse" style="display: none">
				<div class="row" id="email" style="margin-bottom: 15px;">
					<div id="emailids" class="col-xs-3">

						<form:label path="listofmails">Select EmailId: <font
								color='red'>*</font>
						</form:label>
					</div>
					<div class="col-xs-3">
						<form:errors cssClass="err" htmlEscape="false" path="template"
							element="div" />

						<form:select path="listofmails" id="demonstration"
							name="character0" style="width: 250px" multiple="multiple">
							<form:options items="${emaillist}" />
						</form:select>
					</div>
					<h1 id="result"></h1>
					<div class="col-xs-3">

						<input type="text" id="userInput"
							placeholder=" Specify New Email Id Here " /> <input type="button"
							value="Add" onclick="displayOutput()" />
					
					</div>
					
				</div>
				<div id="listemails" style="display:none">
						<div id="newEmails"></div>
					</div>
			</div>
			<div id="walkinresponse" style="display: none">
				<div id="walkin" class="row"">
					<div class="col-xs-3 " style="width: 150px">
						<label path="date">Walkin Date: </label>
					</div>
					<div class="col-xs-3" style="width: 150px">
						<form:input type="text" placeholder="Select Date" id="datepicker"
							path="date" style="width:120px" />
					</div>
					<div class="col-xs-1" style="width: 80px">
						<label path="time" style="width: 80px height:26px">Time:</label>
					</div>
					<div class="col-xs-1" style="width: 80px">
						<form:input style="width:100px" type="text" id="timepicker"
							name="timepicker" path="time" onclick="picker()"
							class="timepicker form-control" />
						<br> <br>


					</div>

					<div class="col-xs-3">
						<form:label for="timepicker" style="color: #fff" path="time"></form:label>
					</div>
				</div>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-3">
						<label path=venue>Venue:</label>
					</div>
					<div class="col-xs-3">
						<form:textarea path="venue" style="width:350px" />
					</div>
				</div>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-3" style="width: 80px height:26px">
						<form:label path="contactPerson1">Contact Person<font
								color='red'>*</font> :</form:label>
					</div>
					<div class="col-xs-3" style="width: 80px height:26px">
						<form:errors cssClass="err" path="contactPerson1"
							htmlEscape="false" element="div" />
						<form:input path="contactPerson1" />
					</div>
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-6">
					<input type="checkbox" id="myCheck"><b>Do not Display
						this EmailId to Applicants</b>
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-6">
					<input type="checkbox" id="myCheck"><b>Allow Applicants
						to send Query ?</b>
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-6">
					<input type="checkbox" id="myCheck"><b>Share this job
						and its Responses with other Sub-users ?</b>
				</div>
			</div>


			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-6">
					<input type="checkbox" id="myCheck"><b>Auto forward all
						Application to EmailId</b>
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-6">
					<input type="checkbox" id="myCheck"><b>Share this job
						with other Sub-user ?</b>
				</div>
			</div>

			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="responseCode">Response Code<font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					<form:errors cssClass="err" path="responseCode" htmlEscape="false" />
					<form:input path="responseCode" />
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-4">
					<label><b>Set Response Preferences :</b></label>
				</div>
				<div class="col-xs-3">
					<input type="checkbox" id="myCheck">
				</div>
			</div>
			<h3>Job Visibility Option</h3>
			<div class="row" style="margin-bottom: 15px;">

				<form:form method="POST" commandName="upload"
					enctype="multipart/form-data">
					<div class="col-xs-3">
						<form:errors path="*" cssClass="errorblock" element="div" />
						<label><b>Photo : </b></label>
					</div>
					<div class="col-xs-3">
						<input type="file" name="file" path="file"/>
					</div>
					 <%-- <div class="col-xs-3">
						<input type="submit" value="upload photo(s)" /> <span><form:errors
								path="file" cssClass="error" /></span>
					</div>  --%>
				</form:form>
			</div>
			<h3>Shedule Refresh</h3>
			<div>
				<div class="row" style="margin-bottom: 15px;">
					<div class="col-xs-4">
						<form:label path="refreshPeriod">Refresh this job for every:<font
								color='red'>*</font> :</form:label>
					</div>
					<div class="col-xs-1">
						<form:errors cssClass="err" path="refreshPeriod"
							htmlEscape="false" element="div" />
						<form:select path="refreshPeriod">
							<form:option label="-- select-- " value="-1" />
							<form:option label="1 Week" value="1" />
							<form:option label="2 Weeks" value="2" />
							<form:option label="3 Weeks" value="3" />
							<form:option label="4 Weeks" value="4" />
						</form:select>
					</div>
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<input type="button" value="Preview" onclick="popupform(this);"
						style="height: 40px; width: 150px" />
				</div>
				<div class="col-xs-3">
					<input type="submit" value="Save" 
						style="height: 40px; width: 150px" />
				</div>
				<div class="col-xs-3">
					<input type="submit" value="SaveAndPost" 
						style="height: 40px; width: 150px" />
				</div>
				<div class="col-xs-3">
					<input type="submit" value="Post" 
						style="height: 40px; width: 150px" />
				</div>
				</div>
				<!-- Preview, Save, Save & Post, Post -->
	</form:form>




	<%-- <div class="col-xs-3" style="width: 150px;">
		<form:form method="GET" commandName="clilogoutAction"
			action="clientloginpage">
			<input type="submit" value="Logout"
				style="height: 40px; width: 150px" />
		</form:form>

	</div> --%>
	<!--  </div> -->
</body>
</html>