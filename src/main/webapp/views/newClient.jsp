<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>JPL - Client Registration</title>
<spring:url value="/scripts/jquery-1.10.2.js" var="jqueryJs" />
<spring:url value="/scripts/jquery-ui.js" var="jqueryuiJs" />
<spring:url value="/scripts/jpl-cities.js" var="jplcitiesJs" />
<spring:url value="/scripts/jpl-citymapping.js" var="jplcitymappingJs" />
<spring:url value="/scripts/jpl-datavalidation.js" var="jpldatavalidationJs" />
<spring:url value="/scripts/jpl-statemapping.js" var="jplstatemappingJs" />
<spring:url value="/scripts/jpl-newclient.js" var="jplstatemappingJs" />
<spring:url value="/styles/NewClient.css" var="NewClient" />

<link href="${NewClient}" rel="stylesheet" />

<script src="${jqueryJs}"></script>
<script src="${jqueryuiJs}"></script>
<script src="${jplcitiesJs}"></script>
<script src="${jplcitymappingJs}"></script>
<script src="${jpldatavalidationJs}"></script>
<script src="${jplstatemappingJs}"></script>


</head>
<body>
	<fieldset id="msform">
		
		<div>
			<h1 class="fs-title">New Client Registration</h1>
			<hr>
		</div>
		<div>
			<form:form method="POST" commandName="clientForm" action="cliregister">
				<div>
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="clientType" >Client Type: </form:label>
						</div>
						
						<div >
							<form:radiobutton path="clientType" value="1" />Company
							
							<form:radiobutton path="clientType" value="2" />Consultant
							
							<form:radiobutton path="clientType" value="3" />Training Institute
						</div>
					</div>
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="clientName">Client Name <font	color='red'>*</font>                            
							</form:label>
						</div>
						
						<div >
							<form:input	path="clientName" TABINDEX="true"/>
							<form:errors cssClass="err" path="clientName"  htmlEscape="false" />
						</div>
					</div>
<div>
						<div class="wrapper">
							<form:label path="CompanyDetailsDm.companyName">Company Name <font	color='red'>*</font>                            
							</form:label>
						</div>
						
						<div >
							<form:input	path="CompanyDetailsDm.companyName" />
							<form:errors cssClass="err" path="CompanyDetailsDm.companyName"  htmlEscape="false" />
						</div>
					</div>

					<div class="wraperclass">	
						<div class="wrapper">
							<form:label path="contactPerson">Contact Person: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div >
							<form:input	path="contactPerson" />
							<form:errors cssClass="err" path="contactPerson"  htmlEscape="false" />
						</div>
					</div>
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="emailId">Email Id: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div >
							
							<form:input	cssErrorClass="err" path="emailId" id="emailId" />
							<span id="emailerr" style="color:blue"  hidden="true"></span>
							<form:errors cssClass="err" path="emailId"  htmlEscape="false" />
						</div>
					</div>
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="password">Password: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div >
							
							<form:password path="password" id="password" />
							<span id="passworderr" style="color:blue"  hidden="true"></span>
							<form:errors cssClass="err"	path="password" htmlEscape="false"  />
						</div>
						
						<div class="wrapper">
							<form:label path="matchingPassword">Confirm Password: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div >
							
							<form:password path="matchingPassword" />
							<span id="matchpassworderr" style="color:blue"  hidden="true"></span>
							<form:errors cssClass="err" path="matchingPassword" htmlEscape="false"  />
						</div>
					</div>
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="contactNumber">Mobile Number: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div >
							
							<form:input path="contactNumber" />
							<form:errors cssClass="err" path="contactNumber" htmlEscape="false"  />
						</div>
					</div>
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="landlinenoId">Landline Number:
							</form:label>
						</div>
						<div >
							
							<form:input path="landlinenoId" id="countryiso" class="small-box"  disabled="true" />
							<form:input path="landlinenoId"  class="small-box"/>
							<form:input path="landlinenoId" class="small-box"/>
							<form:errors cssClass="err" path="landlinenoId"  htmlEscape="false" />
						</div>
					</div>
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="industryDetailsId">Industry Type: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div>
							
							<form:select path="industryDetailsId" id="industryDetailsId" class="my_select">
								<form:option label="-- Select one --" value="-1" />
								<form:options items="${industryDetailsList}" itemLabel="industryType" itemValue="industryDetailsId" />
								<form:option label="-- Other --" value="0" />
								
							</form:select>
							<form:errors cssClass="err" path="industryDetailsId" htmlEscape="false" element="varIndId" />
							
							
							<varIndId id="newIndustryDiv" class="test">
							<form:input path="newIndustry" />
							
							</varIndId>
						</div>
					</div>
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="website">Website:</form:label>
						</div>
						<div >
							
							<form:input path="website" />
							<form:errors cssClass="err" path="website" htmlEscape="false"  />
						</div>
					</div>
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="countryId"> Country: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div >
							
							<form:select path="countryId" id="countryId" class="my_select">
								<form:option label="-- Select one --" value="-1" />
								<form:options items="${countriesList}" itemLabel="countryName" itemValue="countryId" />
							</form:select>
							<form:errors cssClass="err"	path="countryId" htmlEscape="false"  />
						</div>
					</div>
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="stateId">State: <font color='red'>*</font>
							</form:label>
						</div>
						
						<div >
							
							<form:select path="stateId" class="my_select">
								<form:option label="-- Select one --" value="-1" />
								<form:options items="${statesList}" itemLabel="stateNm"	itemValue="stateId" />
								
							</form:select>	
							<form:errors cssClass="err"  path="stateId" htmlEscape="false" />
						</div>
								
					</div>		
					
					<div class="wraperclass">	
						<div class="wrapper">
								
							<form:label path="cityName">City: <font	color='red'>*</font>
							</form:label>
						</div >
						<div >
							<form:input path="cityName" />
							<form:errors cssClass="err"  path="cityName" htmlEscape="false" />
						</div>
							
							
					</div>
					
					
					<div class="wraperclass">
						<div class="wrapper">
								<div >
									<form:label path="CompanyDetailsDm.addrLine1">Address:</form:label>
								</div>
								
							
						</div>
						<div style="float:left">
								<div >
									<form:input path="CompanyDetailsDm.addrLine1" />
								</div>
						
								<div>
								   
										<form:input path="CompanyDetailsDm.addrLine2" />
								</div>
								<div>
										<form:input path="CompanyDetailsDm.addrLine3" />
								</div>
						</div>
					</div>
					
					
					<div class="wraperclass">
						<div class="wrapper">
							<form:label path="pincode">Pincode:<font color='red'>*</font>
							</form:label>
						</div>
						
						<div>
							
							<form:input path="pincode" />
							<form:errors cssClass="err" path="pincode"  htmlEscape="false" />
						</div>
					</div>
					
					<div>
						<div class="my_button">
								<input type="submit" value="Register"  />
								
								<input type="button" value="Cancel" onclick="window.location.href='http://localhost:8080/jobpluslearn'" />
								
						</div>
					</div>
				</div>
			</form:form>
		</div>
        
    </fieldset>
</body>

</html>