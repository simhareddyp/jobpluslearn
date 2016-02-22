function pickcal() {
		$('#demo-3').monthpicker().bind(
				'monthpicker-change-year',
				function(e, year) {
					$('#demo-3').monthpicker('disableMonths', []); // (re)enables all
					if (year === '2015') {
						$('#demo-3').monthpicker('disableMonths',
								[ 1, 2, 3, 4 ]);
					}
					if (year === '2014') {
						$('#demo-3').monthpicker('disableMonths',
								[ 9, 10, 11, 12 ]);
					}
				});

		$('#demo-3-button').bind('click', function() {
			$('#demo-3').monthpicker('show');
		});
	}
function pickcal1() {
		$('#demo-4').monthpicker().bind(
				'monthpicker-change-year',
				function(e, year) {
					$('#demo-4').monthpicker('disableMonths', []); // (re)enables all
					if (year === '2015') {
						$('#demo-4').monthpicker('disableMonths',
								[ 1, 2, 3, 4 ]);
					}
					if (year === '2014') {
						$('#demo-4').monthpicker('disableMonths',
								[ 9, 10, 11, 12 ]);
					}
				});

		$('#demo-4-button').bind('click', function() {
			$('#demo-4').monthpicker('show');
		});
	}
function pickcal2() {
		$('#demo-5').monthpicker().bind(
				'monthpicker-change-year',
				function(e, year) {
					$('#demo-5').monthpicker('disableMonths', []); // (re)enables all
					if (year === '2015') {
						$('#demo-5').monthpicker('disableMonths',
								[ 1, 2, 3, 4 ]);
					}
					if (year === '2014') {
						$('#demo-5').monthpicker('disableMonths',
								[ 9, 10, 11, 12 ]);
					}
				});

		$('#demo-5-button').bind('click', function() {
			$('#demo-5').monthpicker('show');
		});
	}
function pickcal3() {
		$('#demo-6').monthpicker().bind(
				'monthpicker-change-year',
				function(e, year) {
					$('#demo-6').monthpicker('disableMonths', []); // (re)enables all
					if (year === '2015') {
						$('#demo-6').monthpicker('disableMonths',
								[ 1, 2, 3, 4 ]);
					}
					if (year === '2014') {
						$('#demo-6').monthpicker('disableMonths',
								[ 9, 10, 11, 12 ]);
					}
				});

		$('#demo-6-button').bind('click', function() {
			$('#demo-6').monthpicker('show');
		});
	}
$(function() {
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
																	$(
																			"#branchId")
																			.append(
																					"<option value='"
															+ optionData.branchId
          												+ "'>"
																							+ optionData.description
																							+ "</option>");

																});
											});
						});
	});