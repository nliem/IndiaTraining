
$(function(){
	var options = {
			type: "GET",
			dataType: "json",
			url: "http://services.groupkt.com/state/get/ind/all",
			error: function(xhr, textStatus, errorThrown){
				alert("Error");
			},
			success:function(data, textStatus){
				
			}
	};
	
	$.ajax(options);

});