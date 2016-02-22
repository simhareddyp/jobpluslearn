$(function() {$("#emailId")
			.change(
					function() {

						$
								.get(
										"http://localhost:8080/jobpluslearn/validateData/emailValidate",
										{
											emailId : $("#emailId").val(),
											typeofuser : $("form").attr('id')

										}, function(emailIdAlreadyExists) {
										
											if (emailIdAlreadyExists == "") {

												$("#emailerr").hide();
											} else {
												$("#emailerr").text(
														emailIdAlreadyExists);
												$("#emailerr").show();
											}

										});

					});

});
$(function() {
	$("#password").blur(function() {
		if (this.value == "") {

			$("#passworderr").text("Password Cannot be Empty");
			$("#passworderr").show();

		} else if (this.value.length < 6) {
			$("#passworderr").text("Password length must be more than 6");
			$("#passworderr").show();
		} else {
			$("#passworderr").hide();
		}
	});
});

$(function() {
	$("#emailId").blur(function() {
		if (this.value == "") {

			$("#emailerr").text("Email Id Cannot be Empty");
			$("#emailerr").show();

		} else
			$("#emailerr").hide();
		;

	});
});
$(function() {
	$("#matchingPassword").blur(
			function() {

				if ($("#password").val() != this.value) {
					$("#matchpassworderr").text(
							"Password not maching with Confirm Password");
					$("#matchpassworderr").show();

				} else if (this.value == "") {
					$("#matchpassworderr").text(
							"Confirm Password Cannot be empty");
					$("#matchpassworderr").show();

				} else {

					$("#matchpassworderr").hide();
				}

			});
});
$(function() {
	$("#contactNumber")
			.change(
					function() {

						$
								.get(
										"http://localhost:8080/jobpluslearn/validateData/mobileValidate",
										{
											contactNumber : $("#contactNumber")
													.val(),
													typeofuser : $("form").attr('id')

										}, function(mobilenumber) {

											if (mobilenumber == "") {

												$("#contactNumbererr").hide();
											} else {
												$("#contactNumbererr").text(
														mobilenumber);
												$("#contactNumbererr").show();
											}

										});

					});
});

$(function() {
$("#countryId").change(function() {

	$.get

("http://localhost:8080/jobpluslearn/validateData/countryiso", {
		countryId : $("#countryId").val()

	}, function(countryiso) {

		$("#countryiso").val(countryiso)

	});

});
});
