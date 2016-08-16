/**
 * 
 */

var myfunction = function(){
	alert("Hi from myfunction");
};//not called unless invoked

function greet(){
	return "Hello World";
}

function showGreeting(funRef){
	var msg = funRef();
	console.log(msg);
}

(function(){
	alert("Hi from sef executing...");
	
	myfunction();
	
	showGreeting(greet); //can't do showGreeting(greet()) b/c passing in string 
})();