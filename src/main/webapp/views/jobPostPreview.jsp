<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class= "preview">
<h1 class="fs-title">Job Posting Form - Hot Vacancy</h1>
<h3>Job Details</h3>
	<div class="container">
			<div class="row">
				<div class="col-xs-3">
					<form:label path="template">Job  <font
							color='red'>*</font> :</form:label>
				</div>
				${postForm.autofill}
			</div>
						
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="jobTitle"> Job Title/Designation <font
							color='red'>*</font> :</form:label>
				</div>
				<div class="col-xs-3">
					${postForm.jobTitle}
				</div>
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">
					<form:label path="numberofvacancies"> Number of Vacancies :</form:label>
				</div>
				<div class="col-xs-3">
					${postForm.numberofvacancies}
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
					${postForm.jobDescription}
				</div>
				
			</div>
			<div class="row" style="margin-bottom: 15px;">
				<div class="col-xs-3">

					<form:label path="keywords">	Keywords:<font
							color='red'>*</font>
					</form:label>
				</div>
				<div class="col-xs-3">
					${postForm.keywords}
				</div>
			</div>
			
</div>
</div>
</body>
</html>