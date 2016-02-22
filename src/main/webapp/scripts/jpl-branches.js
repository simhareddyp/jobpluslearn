/*$(function() {

	var lastSelCity = null;
	jQuery("#levelcode")
			.autocomplete(
					{
						source : function(request, response) {
							jQuery
									.get(
											"http://localhost:8080/jobpluslearn/refData/getBranches1",
											{
												description : request.term,
												description : $(
														"#levelcode")
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
alert("sssss")
	$('#levelcode').autocomplete({
		

		serviceUrl: 'http://localhost:8080/jobpluslearn/refData/getBranches1',
		paramName: "description", 
	
		delimiter: ",",
	   transformResult: function(response) {
		    	
		return {      	
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {
		            	
		      return { value: item.tagName, data: item.id };
		   })
		            
		 };
		        
            }
		    
	 });
				
  });




$(function () {
	alert("ffff")

	
    var description = $('#levelcode').val();
    //http://techbrij.com/987/jquery-ui-autocomplete-asp-net-web-api
    $("#autocomplete").autocomplete({
        source: function (request, response) {
        	alert("wwwwww")
            $.ajax({
                url: "http://localhost:8080/jobpluslearn/refData/getBranches1?description=" + description,
                type: 'GET',
                cache: false,
                data: request,
                dataType: 'json',
                success: function (json) {
                    // call autocomplete callback method with results 
                    response($.map(json, function (name) {
                        return {
                            label: name.FullName,
                            value: name.FriendID
                        };
                    }));
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#levelcode").text(textStatus);
                }
            });
        },
        select: function (event, ui) {
            alert('you have selected ' + ui.item.label + ' ID: ' + ui.item.value);
            $('#autocomplete').val(ui.item.label);
            return false;
        },
        messages: {
            noResults: '',
            results: function () {
            }
        }
    });
});*/

function split(val) {
    return val.split(/,\s*/);
}
function extractLast(term) {
    return split(term).pop();
}
 
$(document).ready(function() {
 
    $( "#levelcode" ).autocomplete({
        source: 'http://localhost:8080/jobpluslearn/refData/getBranches1'
    });
     
          
});



