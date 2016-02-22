<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">


<title>JPL - User Registration</title>

<spring:url value="/styles/jquery-ui.css" var="jquery_ui" />
<spring:url value="/styles/NewUser.css" var="NewUser" />
<spring:url value="/scripts/jquery-1.10.2.js" var="jqueryJs" />
<spring:url value="/scripts/jquery1.11.3.min.js" var="jqueryuiJs" />
<spring:url value="/scripts/jpl-cities.js" var="jplcitiesJs" />
<spring:url value="/scripts/jpl-citymapping.js" var="jplcitymappingJs" />
<spring:url value="/scripts/jpl-colleges.js" var="jplcollegesJs" />
<spring:url value="/scripts/jpl-date.js" var="jpldateJs" />
<spring:url value="/scripts/jpl-date.js" var="jpldateJs" />
<spring:url value="/scripts/jpl-datavalidation.js"	var="jpldatavalidationJs" />
<spring:url value="/scripts/jpl-userscripts.js" var="jpluserscriptsJs" />
<spring:url value="/scripts/jquery.min.js" var="jqueryuiminJs" />
<spring:url value="/scripts/jquery-ui.min.js" var="jpljueryuiminJs" />

<spring:url value="/scripts/jquery.mtz.monthpicker.js" var="jplmonthpickJs" />

<link href="${jquery_ui}" rel="stylesheet" />
<link href="${NewUser}" rel="stylesheet" />
<script src="${test}"></script>
<script src="${jqueryJs}"></script>
<script src="${jqueryuiJs}"></script>
<script src="${jplcitiesJs}"></script>
<script src="${jplcitymappingJs}"></script>
<script src="${jplcollegesJs}"></script>
<script src="${jpldateJs}"></script>
<script src="${jpluniversitymappingJs}"></script>
<script src="${jpldatavalidationJs}"></script>
<script src="${jpluserscriptsJs}"></script>

<script src="${jqueryuiminJs}"></script>
<script src="${jpljueryuiminJs}"></script>
<script src="${jplmonthpickJs}"></script>

<style>

</style>

</head>
<body onload='experiencefunction()'>
	<fieldset id="msform">
		<div>
				<h1 class="fs-title">New User Registration</h1>
				<hr>
		</div>
		
		<form:form method="POST" commandName="userForm" action="userregister">
			<div>
				<div>
					<div class="wrapper">
							<form:label path="isFresher">Current Experience :</form:label>
					</div>
					<div class="radio_btn">
						<form:hidden id="fresherflag" path="isFresher" value="N" />
						<input type="radio" name="job" id="experience" onclick="experiencefunction()" checked value="experience" />Experience
						<input type="radio" name="job" id="fresher"	onclick="fresherfunction()" value="fresher" />Fresher 
					</div>
				</div>
					<div>

						<div>
							<div class="wrapper">
								<form:label path="firstName">First Name <font color='red'>*</font> :</form:label>
							</div>
							<div>
								
								<form:input path="firstName" />
								<form:errors cssClass="err" path="firstName" htmlEscape="false"	 />
							</div>

							<div class="wrapper">
								<form:label path="lastName">Last Name <font	color='red'>*</font> :</form:label>
							</div>
							<div>
								<form:input path="lastName" />
								<form:errors cssClass="err" path="lastName" htmlEscape="false" />
							</div>
						</div>

						<div>
							<div class="wrapper">
								<form:label path="emailId">Email Id <font color='red'>*</font> :</form:label>
							</div>
							<div>
								<form:input cssErrorClass="err" path="emailId" />
								<span id="emailerr" style="color: blue" hidden="true"> </span>
								<form:errors cssClass="err" path="emailId" id="emailId"	htmlEscape="false"  />
							</div>
						</div>

						
							<div class="wrapper">
								<form:label path="userName">UserName <font color='red'>*</font> :</form:label>
							</div>
							<div>	
								<form:input cssErrorClass="err" path="userName" />
								<form:errors cssClass="err" path="userName" htmlEscape="false"  />
							</div>
						
						<div>
							<div class="wrapper">
								<form:label path="password"> Password <font	color='red'>*</font> :</form:label>
							</div>
							<div>
								<form:password path="password" />
								<span id="passworderr" style="color: blue" hidden="true"> </span>
								<form:errors cssClass="err" path="password" htmlEscape="false" />
							</div>

							<div class="wrapper">
								<form:label path="reEnterPassword">Confirm Password <font color='red'>*</font> :</form:label>
							</div>
							<div>
								<form:password path="reEnterPassword" />
								<span id="matchpassworderr" style="color: blue" hidden="true"></span>
								<form:errors cssClass="err" path="reEnterPassword" htmlEscape="false"  />
								
							</div>
						</div>

				</div>


				<h3>Personal Details</h3>
				<div>
					
						<div class="wrapper">
							<form:label path="mobileNumber">Mobile Number <font	color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:input path="mobileNumber" id="contactNumber" />
							<span id="contactNumbererr" style="color: blue" hidden="true"></span>
							<form:errors cssClass="err" path="mobileNumber" htmlEscape="false"  />
						</div>
					

					
						<div class="wrapper">
							<form:label path="genderId"> Gender <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="genderId" class="my_select">
								<form:option label="-- Select Gender -- " value="-1" />
								<form:options items="${gender}" itemLabel="genderId" itemValue="genderId" />
								<form:option label="Female" value="0" />
								<form:option label="Male" value="1" />
							</form:select>
							<form:errors cssClass="err" path="genderId" htmlEscape="false" />
						</div>
					
					
						<div class="wrapper">
							<form:label path="nationalityId"> Nationality <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="nationalityId" class="my_select">
								<form:option label="-- Select Nationality -- " value="-1" />
								<form:options items="${nationality}" itemLabel="nationalityId" itemValue="nationalityId" />
								<form:option label="India" value="0" />
							</form:select>
							<form:errors cssClass="err" path="nationalityId" htmlEscape="false"	 />
						</div>
					

					
						<div class="wrapper">
							<form:label path="countryId"> Country:<font	color='red'>*</font></form:label>
						</div>
						<div>
							
							<form:select path="countryId" id="countryId" class="my_select">
								<form:option label="-- Select one --" value="-1" />


								<form:options items="${countriesList}" itemLabel="countryName"	itemValue="countryId" />
							</form:select>
							<form:errors cssClass="err" path="countryId" htmlEscape="false"	 />
						</div>
					
					<div>
						<div class="wrapper">
							<form:label path="stateId">State <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="stateId" class="my_select">
								<form:option label="-- Select State--" value="-1" />
								<form:options items="${statesList}" itemLabel="stateNm"	itemValue="stateId" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="stateId" />
						</div>

						<div class="wrapper">
							<form:label path="cityName">City <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:input path="cityName" />
							<form:errors cssClass="err" htmlEscape="false" path="cityName"  />
						</div>
					</div>
				</div>

				<h3>Educational Details</h3>
				<div>

					<div>
						<div class="wrapper">
							<form:label path="levelId">Highest Qualification <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="levelId" class="my_select">
								<form:option label="-- Select Highest Qualification --" value="-1" />

								<form:options items="${levelsList}" itemLabel="levelCode" itemValue="levelId" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="levelId"  />
						</div>
						
						<div class="wrapper">
							<form:label path="branchId">Branch <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="branchId" class="my_select">
								<form:option label="-- Select Branch --" value="-1" />
								<form:options items="${branchesList}" itemLabel="description" itemValue="branchId" />
								<form:option label="-- Other --" value="0" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="branchId"  />
						</div>
						<div  >
							
							<div id="newBranchDiv">
								<form:input path="newBranch" />
							</div>
							<form:errors cssClass="err" path="newBranch" htmlEscape="false"	 />
						</div>

					</div>
					<div>
						<div class="wrapper">
							<form:label path="universityId">University <font color='red'>*</font> :</form:label>
						</div>
						<div  >
							
							<form:select path="universityId" class="my_select">
								<form:option label="-- Select University --" value="-1" />
								<form:options items="${universitiesList}" itemLabel="description" itemValue="universityId" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="universityId"	 />
						</div>

						<div class="wrapper">
							<form:label path="description">College <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:input path="description" />
							<form:errors cssClass="err" htmlEscape="false" path="description" />
						</div>
					</div>
					<div>
						<div class="wrapper">
							<form:label path="startDate">Start Date :</form:label>
						</div>
						<div>
							
							<input name="startDate" class="calendar_txtbx initcalender" id="txtStartDt" type="text"  />
							<input type="button" class="calendar_btn" value="..." id="btnStartDt" >
							
							<form:label path="endDate">End Date :</form:label>
												
							<form:errors cssClass="err" path="endDate" htmlEscape="false"  />
							<input name="endDate" class="calendar_txtbx initcalender" id="txtEndDt" type="text"   />
							 <input type="button" class="calendar_btn" value="..." id="btnEndDt" > 
							 <form:errors cssClass="err" path="startDate" htmlEscape="false"	element="div" />
						</div>
					</div>
				
				<div id="tblmarks">
					
						<div  class="wrapper">
							<form:label path="marks">Marks (%/CGPA) <font color='red'>*</font> :</form:label>
						</div>
						<div>
							<input name=marks id="marks" type="text" />
						</div>
				</div>
			</div>

			

				<div id="exp">
				<h3 >Work Experience</h3>	
						<div class="wrapper">
							<form:label path="skills">Key Skills :</form:label>
						</div>
						<div>
							
							<form:input cssErrorClass="err" path="skills" />
							<form:errors cssClass="err" path="skills" htmlEscape="false"  />
						</div>
					
					
						<div class="wrapper">
							<form:label path="experience"> Experience  :</form:label>
						</div>
						<div>
							
							<form:select path="experience" class="my_select">
								<form:option label="-- Select Experience -- " value="-1" />
								<form:options items="${experience}" itemLabel="experience" itemValue="experience" />
								<form:option label="< than 1 Year" value="0" />
								<form:option label="1 Year" value="1" />
								<form:option label="2 Years" value="0" />
								<form:option label="3 Years" value="0" />
								<form:option label="4 Years" value="0" />
								<form:option label="5 Years" value="0" />
								<form:option label="6 Years" value="0" />
								<form:option label="7 Years" value="0" />
								<form:option label="8 Years" value="0" />
								<form:option label="9 Years" value="0" />
								<form:option label="10 Years" value="0" />
								<form:option label="10+ Years" value="0" />

							</form:select>
							<form:errors cssClass="err" path="experience" htmlEscape="false"  />
						</div>
					
					<div>
						<div class="wrapper">
							<form:label path="industryDetailsId">Industry  <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="industryDetailsId" class="my_select">
								<form:option label="-- Select Industry --" value="-1" />
								<form:options items="${industryDetailsList}" itemLabel="industryType" itemValue="industryDetailsId" />
								<form:option label="-- Other --" value="0" />

							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="industryDetailsId"  />
						</div>

						<div  >
							
							<div id="newIndustryDiv">
								<form:input path="newIndustry" />
							</div>
							<form:errors cssClass="err" path="newIndustry" htmlEscape="false"  />	
						</div>
					</div>

					
						<div class="wrapper">
							<form:label path="functionalDetailsId">Functional Area <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="functionalDetailsId" class="my_select">
								<form:option label="-- Select functional --" value="-1" />
								<form:options items="${functionalList}" itemLabel="functionalName" itemValue="functionalDetailsId" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="functionalDetailsId" />
						</div>

					

					
						<div class="wrapper">
							<form:label path="titleId">Title <font color='red'>*</font> :</form:label>
						</div>
						<div>
							
							<form:select path="titleId" class="my_select">
								<form:option label="-- Select Title --" value="-1" />
								<form:options items="${titlesList}" itemLabel="description"	itemValue="titleId" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="titleId"  />
						</div>
					
				</div>
				
				<div>
					<div class=my_button>
						<form:input type="submit" value="Register" align="middle" style="height: 40px; width: 150px" path="" />
					
						<input type="button" value="Cancel" onclick="window.location.href='http://localhost:8080/jobpluslearn'" />
					</div>
				</div>
			</div>
		</form:form>
	</fieldset>
	
</body>
</html>