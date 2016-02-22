$(function() {

		$('#emailId').focus(); //Set the default focus

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
		
	});
