$(function() {
	$('#emailId').focus(); // Set the default focus

	$('#newIndustryDiv').hide(); // Hide the 'Other' industry type

	$('#industryDetailsId').on('change', function() {
		var industryDetailsId = $("#industryDetailsId").val();
		if (industryDetailsId == 0) {
			$('#newIndustryDiv').show();
			$('#newIndustry').focus();
		} else {
			$('#newIndustry').val('');
			$('#newIndustryDiv').hide();
		}
	});

	$('#newBranchDiv').hide();
	$('#branchId').on('change', function() {
		$('#branchId').on('change', function() {
			var branchId = $("#branchId").val();
			if (branchId == 0) {
				$('#newBranchDiv').show();
				$('#newBranch').focus();
			} else {
				$('#newBranch').val('');
				$('#newBranchDiv').hide();
			}
		})
	});
	
	$('.initcalender').monthpicker();

	$('#btnStartDt').bind('click', function () {
	    $('#txtStartDt').monthpicker('show');
	});
	
	$('#btnEndDt').bind('click', function () {
	    $('#txtEndDt').monthpicker('show');
	});

	
	$("#levelId")
			.change(
					function() {
						$
								.getJSON(
										"http://localhost:8080/jobpluslearn/refData/getBranches",
										{
											levelId : $(
													"#levelId option:selected")
													.val()
										},
										function(data) {
											$("#branchId").empty();

											$("#branchId")
													.append(
															'<option value="-1">-- Select Branch--</option>"');

											$
													.each(
															data,
															function(index,
																	optionData) {
																$("#branchId")
																		.append(
																				"<option value='"
																						+ optionData.branchId
																						+ "'>"
																						+ optionData.description
																						+ "</option>");

															});
										});
					});
	$("#universityId")
			.change(
					function() {
						$
								.getJSON(
										"http://localhost:8080/jobpluslearn/refData/getColleges",
										{
											universityId : $(
													"#universityId option:selected")
													.val()
										},
										function(data) {
											$("#collegeId").empty();
											$("#collegeId")
													.append(
															'<option value="-1">-- Select --</option>"');
											$
													.each(
															data,
															function(index,
																	optionData) {
																$("#collegeId")
																		.append(
																				"<option value='"
																						+ optionData.collegeId
																						+ "'>"
																						+ optionData.description
																						+ "</option>");
															});
										});
					});
	$("#industryDetailsId")
			.change(
					function() {
						$
								.getJSON(
										"http://localhost:8080/jobpluslearn/refData/getFunctions",
										{
											industryDetailsId : $(
													"#industryDetailsId option:selected")
													.val()
										},
										function(data) {
											$("#functionalDetailsId").empty();
											$("#functionalDetailsId")
													.append(
															'<option value="-1">-- Select --</option>"');
											$
													.each(
															data,
															function(index,
																	optionData) {
																$(
																		"#functionalDetailsId")
																		.append(
																				"<option value='"
																						+ optionData.functionalDetailsId
																						+ "'>"
																						+ optionData.functionalName
																						+ "</option>");
															});
										});
					});
	$("#functionalDetailsId")
			.change(
					function() {
						$
								.getJSON(
										"http://localhost:8080/jobpluslearn/refData/getTitles",
										{
											functionalDetailsId : $(
													"#functionalDetailsId option:selected")
													.val()
										},
										function(data) {
											$("#titleId").empty();
											$("#titleId")
													.append(
															'<option value="-1">-- Select --</option>"');
											$
													.each(
															data,
															function(index,
																	optionData) {
																$("#titleId")
																		.append(
																				"<option value='"
																						+ optionData.titleId
																						+ "'>"
																						+ optionData.titleName
																						+ "</option>");
															});
										});
					});
	$("#countryId")
	.change(
			function() {
				$
						.getJSON(
								"http://localhost:8080/jobpluslearn/refData/getStates",
								{
									countryId : $(
											"#countryId option:selected")
											.val()
								},
								function(data) {
									$("#stateId").empty();
									$("#stateId")
											.append(
													'<option value="-1">-- Select --</option>"');
									$
											.each(
													data,
													function(index,
															optionData) {
														$(
																"#stateId")
																.append(
																		"<option value='"
															+ optionData.stateId
          												+ "'>"
																				+ optionData.stateNm
																				+ "</option>");
													});
								});
			});

$("#stateId")
	.change(
			function() {
				$
						.getJSON(
								"http://localhost:8080/jobpluslearn/refData/getUniversities",
								{
									stateId : $(
											"#stateId option:selected")
											.val()
								},
								function(data) {
									$("#universityId").empty();
									$("#universityId")
											.append(
													'<option value="-1">-- Select --</option>"');
									$
											.each(
													data,
													function(index,
															optionData) {
														$(
																"#universityId")
																.append(
																		"<option value='"
															+ optionData.universityId
          												+ "'>"
																				+ optionData.description
																				+ "</option>");
													});
								});
			});
});

function fresherfunction() {

	document.getElementById("fresherflag").value = "Y"
		document.getElementById("tblmarks").style.display = "block"
	document.getElementById("exp").style.display = "none"
	
	

}
function experiencefunction() {

	document.getElementById("fresherflag").value = "N"
	document.getElementById("exp").style.display = "block"
	document.getElementById("tblmarks").style.display = "none"
	
}


