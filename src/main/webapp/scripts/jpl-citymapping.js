$("#stateId")
				.change(
						function() {
							$
									.getJSON(
											"http://localhost:8080/jobpluslearn/refData/getCities",
											{
												stateId : $(
														"#stateId option:selected")
														.val()
											},
											function(data) {
												$("#cityId").empty();
												$("#cityId")
														.append(
																'<option value="-1">-- Select --</option>"');
												$
														.each(
																data,
																function(index,
																		optionData) {
																	$(
																			"#cityId")
																			.append(
																					"<option value='"
 																			+ optionData.cityId
                              												+ "'>"
																							+ optionData.cityNm
																							+ "</option>");
																});
											});
						});