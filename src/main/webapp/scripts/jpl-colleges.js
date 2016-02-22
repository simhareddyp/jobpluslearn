$(function() {

	var lastSelCollege = null;
	jQuery("#description")
			.autocomplete(
					{
						source : function(request, response) {
							jQuery
									.get(
											"http://localhost:8080/jobpluslearn/refData/getColleges",
											{
												collegeName : request.term,
												universityId : $("#universityId option:selected").val()
											}, function(data) {
												response(data);
											});
						},
						minLength : 3,
						response : function(event, ui) {
							lastSelCollege = ui.content[0].value;
						},
					});

});
