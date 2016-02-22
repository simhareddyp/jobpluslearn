<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JPL - Post Login Page</title>

<spring:url value="/styles/NewUser.css" var="NewUser" />
<spring:url value="/styles/jquery-ui.css" var="jqueryuiCss" />
<spring:url value="/scripts/jquery-1.10.2.js" var="jqueryJs" />
<spring:url value="/scripts/jquery-ui.js" var="jqueryuiJs" />
<spring:url value="/scripts/jpl-cities.js" var="jplcitiesJs" />
<spring:url value="/scripts/jpl-citymapping.js" var="jplcitymappingJs" />
<spring:url value="/scripts/jpl-colleges.js" var="jplcollegesJs" />
<spring:url value="/scripts/jpl-date.js" var="jpldateJs" />
<spring:url value="/scripts/jpl-postloginscripts.js"
	var="jplpostloginscriptsJs" />

<spring:url value="/scripts/jquery.min.js" var="jqueryuiminJs" />
<spring:url value="/scripts/jquery-ui.min.js" var="jpljueryuiminJs" />
<spring:url value="/scripts/jpl.monthpicker.js" var="jplmonthpickJs" />

<link href="${NewUser}" rel="stylesheet" />
<link href="${jqueryuiCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${jqueryuiJs}"></script>
<script src="${jplcitiesJs}"></script>
<script src="${jplcitymappingJs}"></script>
<script src="${jplcollegesJs}"></script>
<script src="${jpldateJs}"></script>
<script src="${jplpostloginscriptsJs}"></script>

<script src="${jqueryuiminJs}"></script>
<script src="${jpljueryuiminJs}"></script>
<script src="${jplmonthpickJs}"></script>

</head>
<body>
	<fieldset id="msform">
		<form:form method="POST" commandName="userpostloginForm"
			action="postlogin">

			<h1 class="fs-title">Post Login Page</h1>
			<hr>
			<h3>Personal Details and Educational Details</h3>

				<form:hidden path="UserDm.user1Id" />
				<form:hidden path="UserDm.emailId" />
					
				
				<div>
					<div class="wrapper">
						<form:label path="resumeHeadline">Resume Headline :</form:label>
					</div>
					<div>
						<form:textarea cssErrorClass="err" path="resumeHeadline" />
						<form:errors cssClass="err" path="resumeHeadline"
							htmlEscape="false" />
					</div>
				</div>

				<div class="wrapper">
					<form:label path="UserDm.firstName">First Name :</form:label>
				</div>
				<div>
					<form:input path="UserDm.firstName" />
					<form:errors cssClass="err" path="UserDm.firstName"
						htmlEscape="false" />
				</div>

				<div>
					<div class="wrapper">
						<form:label path="UserDm.lastName">Last Name :</form:label>
					</div>
					<div>
						<form:input path="UserDm.lastName" />
						<form:errors cssClass="err" path="UserDm.lastName"
							htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.stateId">State :</form:label>
					</div>
					<div>
						<form:select path="UserDm.stateId" class="my_select">
							<form:option label="-- Select State--" value="-1" />
							<form:options items="${statesList}" itemLabel="stateNm"
								itemValue="stateId" />
						</form:select>
						<form:errors cssClass="err" htmlEscape="false"
							path="UserDm.stateId" />
					</div>
				</div>

				<div>
					<div class="wrapper">
						<form:label path="UserDm.cityName">Current Location :</form:label>
					</div>
					<div>
						<form:input value="${cityName}" path="UserDm.cityName" />
						<form:errors cssClass="err" htmlEscape="false"
							path="UserDm.cityName" />
					</div>
				</div>
				<form:hidden path="UserDm.cityId" />

				<div>
					<div class="wrapper">
						<form:label path="prefferedLocation">Preferred Location :</form:label>
					</div>
					<div>
						<form:input cssErrorClass="err" path="prefferedLocation" />
						<form:errors cssClass="err" path="prefferedLocation"
							htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="totalExpYears">Total Experience :</form:label>
					</div>
					<div style="float: left">
						<div>
							<form:select path="totalExpYears" class="my_select">
								<form:option label="-- Select Years -- " value="-1" />

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
						<div>
							<form:select path="totalExpMonths" class="my_select">
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
						</div>
						<form:errors cssClass="err" path="totalExpYears"
							htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="annualSalary">Annual Salary :</form:label>
					</div>
					<div>
						<form:select path="annualSalary" class="my_select">
							<form:option label="-- Select Salary -- " value="-1" />
							<form:option label="1" value="1" />
						</form:select>
						<form:errors cssClass="err" path="annualSalary" htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="landlinenoId">Landline Number:</form:label>
					</div>
					<div>
						<form:input path="landlinenoId" />
						<form:errors cssClass="err" path="landlinenoId" htmlEscape="false" />
					</div>

				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.mobileNumber">Mobile Number :</form:label>
					</div>
					<div>
						<form:input path="UserDm.mobileNumber" />
						<form:errors cssClass="err" path="UserDm.mobileNumber"
							htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="dateOfBirth">Date of Birth :</form:label>
					</div>
					<div>
						<input name="dateOfBirth" id="dateOfBirth" type="text" />
						<form:errors cssClass="err" path="dateOfBirth" htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.genderId"> Gender :</form:label>
					</div>
					<div>

						<form:select path="UserDm.genderId" class="my_select">
							<form:option label="-- Select Gender -- " value="-1" />
							<form:options items="${gender}" itemLabel="genderId"
								itemValue="genderId" />
							<form:option label="Female" value="0" />
							<form:option label="Male" value="1" />
						</form:select>
						<form:errors cssClass="err" path="UserDm.genderId"
							htmlEscape="false" />
					</div>
				</div>

				<div>
					<div class="wrapper">
						<form:label path="address">Address :</form:label>

					</div>
					<div style="float: left">
						<div>
							<form:input path="address" />
						</div>
						<div>
							<form:input path="address" />
						</div>
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="pincode">Pincode :</form:label>
					</div>
					<div>

						<form:input path="pincode" />
						<form:errors cssClass="err" path="pincode" htmlEscape="false" />
					</div>

				</div>
				<div>
					<div class="wrapper">
						<form:label path="maritalStatus">Marital Status :</form:label>
					</div>
					<div>
						<form:select path="maritalStatus" class="my_select">
							<form:option label="-- Select -- " value="-1" />
							<form:options items="${maritalStatus}" itemLabel="maritalStatus"
								itemValue="maritalStatus" />
							<form:option label="Married" value="0" />
							<form:option label="Single" value="1" />
							<form:option label="Others" value="2" />
						</form:select>
						<form:errors cssClass="err" path="maritalStatus"
							htmlEscape="false" />
					</div>

				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.skills">Key Skills :</form:label>
					</div>
					<div>
						<form:input cssErrorClass="err" path="UserDm.skills" />
						<form:errors cssClass="err" path="UserDm.skills"
							htmlEscape="false" />
					</div>
				</div>

				<div>
					<h3>Educational Details</h3>
				</div>

				<div>
					<div class="wrapper">
						<form:label path="levelId">Basic/Graduation :</form:label>
					</div>
					<div style="float: left">
						<div>
							<form:select path="levelId" class="my_select">
								<form:option label="-- Select Graduation --" value="-1" />

								<form:options items="${levelsList}" itemLabel="levelCode"
									itemValue="levelId" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false" path="levelId" />
						</div>
						<div class="radio_btn">
							<form:radiobutton path="ugStudytype" value="1" />
							FullTime
							<form:radiobutton path="ugStudytype" value="2" />
							PartTime
							<form:radiobutton path="ugStudytype" value="3" />
							Correspondence/Distance Learning
						</div>
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="branchId">Specialization :</form:label>
					</div>
					<div>
						<form:select path="branchId" class="my_select">
							<form:option label="-- Select Specialization --" value="-1" />
							<form:options items="${branchesList}" itemLabel="description"
								itemValue="branchId" />
						</form:select>
						<form:errors cssClass="err" htmlEscape="false" path="branchId" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="universityId">University :</form:label>
					</div>
					<div>
						<form:select path="universityId" class="my_select">
							<form:option label="-- Select University --" value="-1" />
							<form:options items="${universitiesList}" itemLabel="description"
								itemValue="universityId" />
						</form:select>
						<form:errors cssClass="err" htmlEscape="false" path="universityId" />
					</div>
				</div>

				<div>
					<div class="wrapper">
						<form:label path="startDate1">Start Date :</form:label>
					</div>
					<div>
						<input name="startDate1" id="demo-3" type="text"
							onclick="pickcal()" /> <input type="button" class="calendar_btn"
							value="..." id="demo-3-button" onclick="pickcal()">
						<form:errors cssClass="err" path="startDate1" htmlEscape="false" />
					</div>

					<div class="wrapper">
						<form:label path="endDate1">End Date :</form:label>
					</div>
					<div>
						<input name="endDate1" id="demo-4" type="text"
							onclick="pickcal1()" /> <input type="button"
							class="calendar_btn" value="..." id="demo-4-button"
							onclick="pickcal1()">
						<form:errors cssClass="err" path="endDate1" htmlEscape="false" />
					</div>
				</div>

				<div>
					<div class="wrapper">
						<form:label path="UserDm.levelId">Post Graduation :</form:label>
					</div>
					<div style="float: left">
						<div>
							<form:select path="UserDm.levelId" class="my_select">
								<form:option label="-- Select Graduation --" value="-1" />
								<form:options items="${levelsList}" itemLabel="levelCode"
									itemValue="levelId" />
							</form:select>
							<form:errors cssClass="err" htmlEscape="false"
								path="UserDm.levelId" />
						</div>
						<div class="radio_btn">
							<form:radiobutton path="pgStudytype" value="4" />
							Full Time
							<form:radiobutton path="pgStudytype" value="5" />
							Part Time
							<form:radiobutton path="pgStudytype" value="6" />
							Correspondence/Distance Learning
						</div>
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.branchId">Specialization :</form:label>
					</div>
					<div>
						<form:select path="UserDm.branchId" class="my_select">
							<form:option label="-- Select Specialization --" value="-1" />
							<form:options items="${branchdescription}"
								itemLabel="description" itemValue="UserDm.branchId" />
							<form:options items="${branchListlevelid}"
								itemLabel="description" itemValue="branchId" />
						</form:select>
						<form:errors cssClass="err" htmlEscape="false"
							path="UserDm.branchId" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.universityId">University :</form:label>
					</div>
					<div>
						<form:select path="UserDm.universityId" class="my_select">
							<form:option label="-- Select University --" value="-1" />
							<form:options items="${universitiesList}" itemLabel="description"
								itemValue="universityId" />
						</form:select>
						<form:errors cssClass="err" htmlEscape="false"
							path="UserDm.universityId" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.startDate">Start Date :</form:label>
					</div>
					<div>
						<input name="UserDm.startDate" id="demo-5" type="text"
							onclick="pickcal2()" value="${startDate}" /> <input type="button"
							class="calendar_btn" value="..." id="demo-5-button"
							onclick="pickcal2()">
						<form:errors cssClass="err" path="UserDm.startDate"
							htmlEscape="false" />
					</div>
				</div>
				<div>
					<div class="wrapper">
						<form:label path="UserDm.endDate">End Date :</form:label>
					</div>
					<div>
						<input name="UserDm.endDate" id="demo-6" type="text"
							onclick="pickcal3()" value="${endDate}" /> <input type="button"
							class="calendar_btn" value="..." id="demo-6-button"
							onclick="pickcal3()">
						<form:errors cssClass="err" path="UserDm.endDate"
							htmlEscape="false" />
					</div>
				</div>
			
		</form:form>
		<div class="my_button">
			<input type="submit" value="Save Changes" />

			<form:form method="POST" commandName="postloginproemp"
				action="postloginproemp">
				<input type="submit" value="Edit Professional Page" />
			</form:form>

			<form:form method="GET" commandName="logoutAction"
				action="userloginpage">
				<input type="submit" value="Logout" />
			</form:form>
		</div>


	</fieldset>
</body>
</html>