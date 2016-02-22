$(function() {
	$("#postjobmenu").click(function() {

		var form = $(document.createElement('form'));
		$(form).attr("action", "newposting");
		$(form).attr("method", "POST");
		$(form).submit();

	});

});

$(function() {
	$("#logoutmenu").click(function() {

		var form = $(document.createElement('form'));
		$(form).attr("action", "clilogoutAction");
		$(form).attr("method", "POST");
		$(form).submit();

	});

});

$(function() {
	$("#trainingsoffered").click(function() {

		var form = $(document.createElement('form'));
		$(form).attr("action", "newtraining");
		$(form).attr("method", "POST");
		$(form).submit();

	});

});
