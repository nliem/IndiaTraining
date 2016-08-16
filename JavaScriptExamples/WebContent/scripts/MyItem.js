/**
 * 
 */

//literal definition
var item = {
	itemNumber:101,
	itemName:'TV' ,
	
	showItem : function(){
		return this.itemName.toUpperCase();
	}
};

//functional definition 
function product(){
	this.product = "laptop";
	this.price = 4500;
	this.showDetails = function(){
		return this.product + " : " + this.price;
	}
}

//function with constructor
function salesMan(name, code){
	this.name = name;
	this.code = code;
	this.showSalesMan = function(){
		return this.name;
	}
}

(function(){
	document.writeln(item.itemNumber);
	document.writeln(item.itemName);
	document.writeln(item.showItem());
})();

(function(){
	var p = new product();
	document.writeln(p.product);
	document.writeln(p.price);
	document.writeln(p.showDetails());
})();

(function(){
	var sm = new salesMan("me", 101);
	document.writeln(sm.name);
	document.writeln(sm.code);
	document.writeln(sm.showSalesMan());
})();