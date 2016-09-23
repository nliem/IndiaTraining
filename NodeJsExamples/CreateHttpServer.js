/**
 * http://usejsdoc.org/
 */

var http = require('http');

	var server = http.createServer(function(request, response){
		response.writeHead(200, {'Content-Type': 'text/plain'});
		response.end('NodeJS Text Response');
	});
	
	server.listen(3000);
	
	console.log("Use Client browser and the access url = http://localhost:3000");
