
$(function(){
	var options = {
			type: "GET",
			dataType: "json",
			url: "http://services.groupkt.com/state/get/ind/all",
			error: function(xhr, textStatus, errorThrown){
				alert("Error");
			},
			success:function(data, textStatus){
				console.log(textStatus);
				
				var results = data.RestResponse.result;
				
				for (var data in results){
					
					var option = "<option value = " + results[data].capital + ">" + results[data].name + "</option>";
					$("#states").append(option);
				}
			}
	};
	$.ajax(options);
	
	$("#states").change(function(){
		console.log($("#states").val());
		$("#capital").val($("#states").val());
	})

});