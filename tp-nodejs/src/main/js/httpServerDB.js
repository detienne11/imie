var http = require('http');

var express = require('express') ;
var logger = require('morgan') ;
var app = express() ;

var hotelService = require('./dal/hotelmongo.js');
var html = require('./ui/hotel.js');

http.createServer(function(req, res){
	var url = req.url;
//	console.log(req);
	console.log('Url :' + url);
	
	
	if (url.match('/hotels.*')){
		
		var test = url.match('/hotels/(\\d{5})/statistiques/(.*)');
		console.log(test);
		
		if (test){
			var codePostal = test[1];
			var action = test[2];
			console.log(codePostal);
			console.log(action);

			if (action == 'capacite') {
				// GET /hotels/:codePostal/statistiques/moyenne
				hotelService.findAvgByCity(codePostal,function(datas){
					var content = html.avgByCity(datas);
					res.writeHead(200, {'Content-Type':'text/html'});
					res.end(content);
				});
			}
			else if (action == 'moyenne') {
				// GET /hotels/:codePostal/statistiques/capacite
				hotelService.findCapacityByCity(codePostal,function(datas){
					var content = html.capacityByCity(datas);
					res.writeHead(200, {'Content-Type':'text/html'});
					res.end(content);
				});
			}			
			
		} else {
			exo1(req, res);
		}
		
	}
	else if (url.match('/hotel.*')){
		
		var test = url.match('/hotel/(\\d+)/(comment|comments)');
		console.log(test);
		
		if (test){
			var id = test[1];
			var action = test[2];
			
			if (action == 'comments'){
				hotelService.findComments(id,function(datas){
					console.log(datas);
					var content = html.avgByCity(datas);
					res.writeHead(200, {'Content-Type':'text/plain'});
					res.end("comments\n");
				});

			}
			else if (action == 'comment'){
				hotelService.addComment(id,function(datas){
					
				});
			}
		}	
		
		exo2(req, res);
	}
	else if (url.match('/ville.*')){		
		exo3(req, res);
	}
	else if (url.match('/load.*')){
		hotelService.loadHotel();
//		res.redirect('http://localhost:86/hotels') ;
		res.writeHead(200, {'Content-Type':'text/plain'});
		res.end('Données Hotels charger');
	}
	else {
		error(req, res);
	}
	
}).listen(90,'localhost');

//url test : http://localhost:86/hotels
// /hotels
var exo1 = function(req, res){
	console.log('exo1 : /hotels');
	
	hotelService.findAll(function(datas){
		var content = html.htmlRender(datas,'exo1');
		res.writeHead(200, {'Content-Type':'text/html'});
		res.end(content);
	})
//	.catch(function(err){
//		console.log(err);
//	});
}

//url test : http://localhost:86/hotel?id=5da6d7a01b101592022ed053b175fdda2b7841ed
///hotel/:id
var exo2 = function(req, res){
	console.log('exo2 : /hotel/:id');
	
	var test = req.url.match('.*\?id=(.*)&?');
	
	if (test) {
		var id = test[1];
		console.log('id=' + id);

		hotelService.findById(id,function(data){
			var content = html.htmlRender(data,'exo2');
			res.writeHead(200, {'Content-Type':'text/html'});
			res.end(content);
		});
		
	}
	else {
		error(req, res);
	}

}

//url test : http://localhost:86/ville?codePostal=75016
//	/ville/:codePostal/hotels
var exo3 = function(req, res){
	console.log('exo3 : /ville/:codePostal/hotels');
//	var msg = "Exo3 : /ville/:codePostal/hotels \n";
	
	var content = null;
	
	var test = req.url.match('.*\?codePostal=(.*)&?');
	console.log(test);
	
	if (test) {
		var codePostal = test[1];
		console.log('codePostal=' + codePostal);
		
		hotelService.findByCity(codePostal,function(datas){
			var content = html.htmlRender3(datas,0, 0);
			res.writeHead(200, {'Content-Type':'text/html'});
			res.end(content);
		});
//		
//		var avg = hotelService.findAvgByCity(codePostal);
//		
//		var capacity = hotelService.findCapacityByCity(codePostal);
//		
//		content = html.htmlRender3(records,avg, capacity);
	}
	else {
		error(req, res);
	}
}

var error = function(req, res){
	console.log('Request : error');
	
	res.writeHead(200, {'Content-Type':'text/plain'});
	res.end('Page inconnu\n');
}

console.log('Server listen on port 82');
