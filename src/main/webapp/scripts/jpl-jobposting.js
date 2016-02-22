function emailfunction() {

	document.getElementById("responseflag").value = "Y"

	if ($('#ppp').is(":checked")) {
		$("#emailresponse").show();
		$("#walkinresponse").hide();
	} else
		$("#emailresponse").hide();

}
function eappsfunction() {

	document.getElementById("responseflag").value = "Y"

	document.getElementById("email").style.display = "none"
	document.getElementById("eapps").style.display = "div"
	document.getElementById("walkin").style.display = "none"

}
function walkinfunction() {

	if ($('#sss').is(":checked")) {
		$("#emailresponse").hide();
		$("#walkinresponse").show();
	} else
		$("#walkinresponse").hide();

}
$(function() {
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
});
$("#levelId")
		.change(
				function() {
					$
							.getJSON(
									"http://localhost:8080/jobpluslearn/refData/getBranches",
									{
										levelId : $("#levelId option:selected")
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

function ShowHideDiv(chkPassport) {
	var dvPassport = document.getElementById("dvPassport");
	dvPassport.style.display = chkPassport.checked ? "block" : "none";
}
function split(val) {
	return val.split(/,\s*/);
}
function extractLast(term) {
	return split(term).pop();
}

$(document)
		.ready(
				function() {
					$("#technologies")
							.autocomplete(
									{
										source : function(request, response) {
											$
													.getJSON(
															"http://localhost:8080/jobpluslearn/refData/getlevelids?query",
															{
																term : extractLast(request.term)
															}, response);
										},
										search : function() {
											// custom minLength
											var term = extractLast(this.value);
											if (term.length < 3) {
												return false;
											}
										},
										focus : function() {
											// prevent value inserted on focus
											return false;
										},
										select : function(event, ui) {

											var terms = split(this.value);
											// remove the current input
											terms.pop();
											// add the selected item
											terms.push(ui.item.label);
											// add placeholder to get the
											// comma-and-space at the end
											terms.push("");

											// $("selectedvals").taginput(ui.item.value);
											this.value = terms.join(", ");
											return false;
										}
									});

				});
