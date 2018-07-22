//var express=require('express');
//var app=express();
//app.get('/',function(req,res)
//{
//res.send('Hello World!');
//});
//var server=app.listen(1107,function() {});
//console.log("Test");

console.log("Welcome");
console.error('error');

var http = require('http');
var fs = require('fs');
var server = http.createServer(function(request, response) {
var url = request.url;

switch(url){
	case '/':
		response.writeHead(200, {"Content-Type":"text/html"});
		fs.readFile("./Home.html", function(err, data) {
			if(err){
				console.error(err);
			}
			response.write(data);
			response.end();
		});
		//response.end();
		break;
	case '/ContactUs':
		response.writeHead(200, {"Content-Type":"text/html"});
		response.end("Contact Us page");
		break;
	case '/AboutUs':
		response.writeHead(200, {"Content-Type":"text/html"});
		response.end("About US page");
		break;
	default:
		//response.write("Test");
    }

}).listen(1107);












