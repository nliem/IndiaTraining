/**
 * http://usejsdoc.org/
 */

var fs = require('fs');

console.log("Reading from Directory");

fs.readdir("temp", function(err, files){
	if(err){
		return console.error(err);
	}
	files.forEach(function(file){
		console.log(file);
	});
});