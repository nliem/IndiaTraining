/**
 * http://usejsdoc.org/
 */

var http = require('http');

var server = http.createServer(function(request, response){
	if(request.url === '/data'){
		response.writeHead(200, {'Content-Type': 'application/json'});
		response.write(JSON.stringify({user:"Ramesh", location:"Chennai"}));
		response.end();
	}
	else{
		response.writeHead(200, {'Content-Type': 'text/plain'});
		response.end('Add /data to url to view json');
	}
});

server.listen(3100);

console.log("Server Listening on port 3100");