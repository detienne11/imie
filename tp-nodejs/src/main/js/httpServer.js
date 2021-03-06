var http = require('http');

var hotelService = require('./dal/hotelfile.js');
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
				var avg = hotelService.findAvgByCity(codePostal);
				var content = html.avgByCity(avg);
				res.writeHead(200, {'Content-Type':'text/html'});
				res.end(content);
				
			}
			else if (action == 'moyenne') {
				// GET /hotels/:codePostal/statistiques/capacite
				var capacity = hotelService.findCapacityByCity(codePostal);
				var content = html.capacityByCity(capacity);
				res.writeHead(200, {'Content-Type':'text/html'});
				res.end(content);				
			}			
			
		} else {
			exo1(req, res);
		}
		
	}
	else if (url.match('/hotel.*')){
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
	
}).listen(86,'localhost');

//url test : http://localhost:86/hotels
// /hotels
var exo1 = function(req, res){
	console.log('exo1 : /hotels');
	
// cas 1
//	var msg = "Exo1 : /hotels \n";
//	for (var record of records) {
//		msg = msg + 'Nom: ' + record.nom + + ', ville: ' + record.ville + ', étoiles: ' + record.nbStar +'\n';
////		console.log(record);
//	}
//	res.writeHead(200, {'Content-Type':'text/plain'});
//	res.end(msg);

	var records = hotelService.findAll();
	
	var content = html.htmlRender(records,'exo1');
	res.writeHead(200, {'Content-Type':'text/html'});
	res.end(content);

}

//url test : http://localhost:86/hotel?id=5da6d7a01b101592022ed053b175fdda2b7841ed
///hotel/:id
var exo2 = function(req, res){
	console.log('exo2 : /hotel/:id');
	
//	var msg = "Exo2 : /hotel/:id \n";
	
	var test = req.url.match('.*\?id=(.*)&?');
//	console.log(test);
	
	var content = null;
	
	if (test) {
		var id = test[1];
		console.log('id=' + id);
		
		var record = hotelService.findById(id);		
		content = html.htmlRender(record,'exo2');
		
//		console.log(record);
//		for (var field in record.fields) {
//			msg = msg + field + ' = '+  record.fields[field] + '\n';
//		}
	}
	else {
		content = html.htmlRender(record,'content');
//		msg += "IllegalArgument id\n";
	}
	
	
	res.writeHead(200, {'Content-Type':'text/html'});
	res.end(content);
	
//	res.writeHead(200, {'Content-Type':'text/plain'});
//	res.end(msg);	
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
		
		var records = hotelService.findByCity(codePostal);
		
		var avg = hotelService.findAvgByCity(codePostal);
		
		var capacity = hotelService.findCapacityByCity(codePostal);
		
		content = html.htmlRender3(records,avg, capacity);
		
//		for (var record of records) {
//			for (var field in record.fields) {
//				msg = msg + field + ' = '+  record.fields[field] + ',';
//			}
//			msg += '\n';
//		}
		
	}
	else {
		content = html.htmlRender(record,'content');
//		msg += "IllegalArgument codePostal\n";
	}
		
	res.writeHead(200, {'Content-Type':'text/html'});
	res.end(content);
	
//	res.writeHead(200, {'Content-Type':'text/plain'});
//	res.end(msg);	
}

var error = function(req, res){
	console.log('Request : error');
	
	res.writeHead(200, {'Content-Type':'text/plain'});
	res.end('Page inconnu\n');
}

console.log('Server listen on port 86');

// avec express
//app.get('/',function(req, res){...})

// query string= liste des parametres apres le ? : url ?key1=value&key2=value...
// var userId = req.query.id;
// var userId = req.query.token;

//parameter id dans le get : var userId = req.params.id;