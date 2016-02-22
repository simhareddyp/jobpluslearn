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
