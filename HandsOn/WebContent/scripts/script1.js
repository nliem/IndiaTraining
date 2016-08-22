/**
 * 
 */

//Button Event Handlers

$(function(){
	
	$("#btnReadText").click(function(){
		console.log("Read Text button clicked.")
		var text = $("#tbUserName").val();
		setValue(text);
	});

	$("#btnReadSelect").click(function(){
		console.log("Read Select button clicked.")
		var value = $("#cities").val();
		setValue(value);
	});

	$("#btnReadRadio").click(function(){
		console.log("Read Radio button clicked.")
		var value = $("input[name = agree]:checked").val();
		setValue(value);
	});

	$("#btnReadCheckBox").click(function(){
		console.log("Read Check Box button clicked.")
		var values = "";
		if($("#cbJava").prop("checked") == true){
			values += "Java ";
		}
		if($("#cbDotNet").prop("checked") == true){
			values += ".NET";
		}
		setValue(values);
	});

	$("#btnReadUncheckedRadio").click(function(){
		console.log("Read Unchecked Radio button clicked.")
		var chkValue = $("input[name = agree]:checked").val();
		if(chkValue == "yes"){
			setValue("no");
		}
		else{
			setValue("yes");
		}
		
	});
	
});

function setValue(value){
	$("#tbValue").val(value);
}





