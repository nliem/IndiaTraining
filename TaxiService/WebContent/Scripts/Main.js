/**
 * 
 */

$(function(){
	$("#btnResetLogin").click(function(){
		$("#email").val("");
		$("#password").val("");
		$("#city").val("null");
	})
	
	$("#btnResetRegistration").click(function(){
		$("#rname").val("");
		$("#remail").val("");
		$("#rpassword").val("");
		$("#rtelephone").val("");
		$("#rcity").val("null");
	})
	
	/*
	$("#registerSpan").click(function(){
		alert("HELLO");
		$("#loginForm").attr("hidden", "true");
		$("#registerSpan").attr("hidden", "true");
		$("#registerForm").attr("hidden", "false");
		$("#existingUserSpan").attr("hidden", "false");
	})
	
	$("#existingUserSpan").click(function(){
		alert("HELLO");
		$("#loginForm").attr("hidden", "false");
		$("#registerSpan").attr("hidden", "false");
		$("#registerForm").attr("hidden", "true");
		$("#existingUserSpan").attr("hidden", "true");
	})
	*/
	
})

function switchToRegister(){
	
	$("#loginSpan").attr("hidden", "true");	
	$("#loginForm").attr("hidden", "true");
	$("#registerSpan").attr("hidden", "true");
	
	$("#registerUserSpan").removeAttr("hidden");
	$("#registerForm").removeAttr("hidden");
	$("#existingUserSpan").removeAttr("hidden");
	
}

function switchToLogin(){
	
	$("#registerUserSpan").attr("hidden", "true");
	$("#registerForm").attr("hidden", "true");
	$("#existingUserSpan").attr("hidden", "true");
	
	$("#loginSpan").removeAttr("hidden");
	$("#loginForm").removeAttr("hidden");
	$("#registerSpan").removeAttr("hidden");

}