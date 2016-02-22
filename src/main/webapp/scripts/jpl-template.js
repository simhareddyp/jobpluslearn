$(function() {
	 
	 $("#template")
	 
		.change(

				
				function() {
				if( $("#template").val() != -1)
				{	 $('#target').attr('action', 'template');
					// $("#jobname").attr("disabled", "disabled"); 
					 $( "#target" ).submit();
				}
 
				});

});

function popupform(myform)
{ //myform=document.getElementById("target")
	 if (! window.focus)return true;
window.open('', 'Priview', 'height=200,width=400,scrollbars=yes');
myform.target=windowname; return true; } 