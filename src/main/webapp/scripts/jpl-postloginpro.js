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

	function yesfunction() {

		document.getElementById("serviceflag").value = "Y"
		document.getElementById("service").style.display = "table"

	}
	function nofunction() {

		document.getElementById("serviceflag").value = "N"
		document.getElementById("service").style.display = "none"
	}

	function OnChangeCheckbox(checkbox) {
		if (checkbox.checked) {
			document.getElementById("val").innerHTML = "yes";
			document.getElementById("myCheck").val = "checked";

		} else {
			document.getElementById("val").innerHTML = "no";
			document.getElementById("myCheck").val = "not_checked";

		}
	}

	function OnChangeCheckbox1(checkbox1) {
		if (checkbox1.checked) {
			document.getElementById("val1").innerHTML = "yes1";
			document.getElementById("myCheck1").val = "checked1";

		} else {
			document.getElementById("val1").innerHTML = "no1";
			document.getElementById("myCheck1").val = "not_checked1";

		}
	}
function myempfunction() {
		document.menu.cmd.value = 'emp';
		document.menu.submit();
	}

	$(document).ready(function() {

		$("#emplist").hide();

		$("#empsearch").click(function(e) {
			e.preventDefault();
			$("#emplist").show();
			myempfunction();
		});
	});