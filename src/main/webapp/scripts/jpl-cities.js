$(function() {

	var lastSelCity = null;
	jQuery("#cityName")
			.autocomplete(
					{
						source : function(request, response) {
							jQuery
									.get(
											"http://localhost:8080/jobpluslearn/refData/getCities",
											{
												cityName : request.term,
												stateId : $(
														"#stateId option:selected")
														.val()
											}, function(data) {
												response(data);
											});
						},
						minLength : 3,
						response : function(event, ui) {
							lastSelCity = ui.content[0].value;
						},
					});

});

$(function() {
	var lastSelCity = null;
	jQuery("#UserDm.cityName")
			.autocomplete(
					{
						source : function(request, response) {
							jQuery
									.get(
											"http://localhost:8080/jobpluslearn/refData/getCities",
											{
												cityName : request.term,
												stateId : $(
														"#stateId option:selected")
														.val()
											}, function(data) {
												response(data);
											});
						},
						minLength : 3,
						response : function(event, ui) {
							lastSelCity = ui.content[0].value;
						},
					});

});