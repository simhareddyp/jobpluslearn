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