/**
 * http://usejsdoc.org/
 */

var fs = require('fs');

console.log("Writing to a file");

fs.writeFile('test.txt', 'Wow! Much file writing. Very cool!', function(err){
	if(err){
		return console.error(err);
	}
});

console.log("Data written");
console.log("Reading Data");

fs.readFile('test.txt', 'utf8', function(err, data){
	if(err){
		return console.error(err);
	}
	console.log("Async read: " + data.toString());
});