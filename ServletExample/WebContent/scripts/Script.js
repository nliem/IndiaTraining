/**
 * 
 */


$(function(){
	
	alert("test");
	$("#btnSubmit").click(function(e){
		e.preventDefault();
		var options = {
				type: "GET",
				dataType: "json",
				url: "Form",
				data:$("#forminfo").serialize(),
				error: function(xhr, textStatus, errorThrown){
					alert("Error");
				},
				success:function(data, textStatus){
					console.log(data);
					$("#result").val(data.dues);
				}
		};		
		
		$.ajax(options);

	})
	
	
});