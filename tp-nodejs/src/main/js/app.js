/**
 * IMPORT EXTERNE
 */
var express = require('express') ;
var path = require('path') ;
var bodyParser = require('body-parser');

/**
 * IMPORT INTERNE
 */
var CommentDTO = require('./dal/dto/comment.js').Comment;
var hotelService = require('./dal/hotelmongo.js');

/**
 * CONFIG APP.JS
 */
var app = express() ;
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extened: true}));
app.set('views',path.join(__dirname,'../webapp/views'));
app.set('view engine','ejs');

// url /hotels
app.get('/hotels', function (req, res) {
	console.log('url=/hotels');
	
	hotelService.findAll(function(datas){
//		res.send(datas);
		res.render('hotels',{datas});
	});
	
});

// url /hotel/:id
//url test : http://localhost:91/hotel/5da6d7a01b101592022ed053b175fdda2b7841ed
app.get('/hotel/:id', function (req, res) {
	var id = req.params.id;
	console.log('url=/hotel/:id, id=' + id);

	hotelService.findById(id,function(datas){
//		res.send(datas);
		hotelService.findComments(id,function(comments){
//			console.log(comments);
			res.render('hotel',{datas});
//			res.send(datas);
		});
		
	});
	
});

//url test : http://localhost:91/ville/75016/hotels
///ville/:codePostal/hotels
app.get('/ville/:codePostal/hotels', function (req, res) {
	var codePostal = req.params.codePostal;
	console.log('url=/ville/:codePostal/hotels, codePostal=' + codePostal);

	hotelService.findByCity(codePostal,function(datas){
		res.send(datas);
	});
	
});

//url test : http://localhost:91/hotels/92400/statistiques/moyenne
// /hotels/:codePostal/statistiques/moyenne
app.get('/hotels/:codePostal/statistiques/moyenne', function (req, res) {
	var codePostal = req.params.codePostal;
	console.log('url=/hotels/:codePostal/statistiques/moyenne, codePostal=' + codePostal);
	
	hotelService.findAvgByCity(codePostal,function(datas){
		res.send(datas);
	});
	
});

//url test : http://localhost:91/hotels/92400/statistiques/capacite
///hotels/:codePostal/statistiques/capacite
app.get('/hotels/:codePostal/statistiques/capacite', function (req, res) {
	var codePostal = req.params.codePostal;
	console.log('url=/hotels/:codePostal/statistiques/capacite, codePostal=' + codePostal);

	hotelService.findCapacityByCity(codePostal,function(datas){
		res.send(datas);
	});
	
});

//url test : http://localhost:91/hotels/92400/statistiques/capacite
///hotels/:codePostal/statistiques/capacite
app.get('/hotels/:codePostal/statistiques/capacite', function (req, res) {
	var codePostal = req.params.codePostal;
	console.log('url=/hotels/:codePostal/statistiques/capacite, codePostal=' + codePostal);

	hotelService.findCapacityByCity(codePostal,function(datas){
		res.send(datas);
	});
	
});

//url test : http://localhost:91/hotel/58c7caebae98580f1c4ae0e2/comment
// /hotel/:id/comment
app.get('/hotel/:id/comment', function (req, res) {
	var id = req.params.id;
	console.log('url=/hotel/:id/comment, id=' + id);
	
	var author = "author 1";
	var date = new Date();
	var content = "comment 1";
	
	var comment = new CommentDTO();
	comment.setAuthor(author);
	comment.setDate(date);
	comment.setContent(content);
	comment.setHotelId(id);
//	console.log(comment);
	
	hotelService.addComment(comment,function(err){

		if (err){
			console.log("Erreur ajout comment");
		}
		else {
			res.send("Ok");
		}
		
	});
	
});

app.post('/hotel/:id/comment', function (req, res) {
	console.log('post');
	var id = req.params.id;
	console.log(id);
	console.log(req.method);
	if (req.method == 'POST'){
		console.log('url=/hotel/:id/comment, POST, id=' + id);
		
		var author = req.body.author;
		var content = req.body.content;
		
		if (author != "" && content != ""){
			
			var comment = new CommentDTO();
			comment.setAuthor(author);
			comment.setDate(new Date());
			comment.setContent(content);
			comment.setHotelId(id);
			
			hotelService.addComment(comment,function(err){

				if (err){
					console.log("Erreur ajout comment");
				}
				else {
					res.send("Ok");
				}
				
			});
		}
		
	}
});

//url test : http://localhost:91/hotel/58c7caebae98580f1c4ae0e2/comments
///hotel/:id/comments
app.get('/hotel/:id/comments', function (req, res) {
	var id = req.params.id;
	console.log('url=/hotel/:id/comments, id=' + id);

	hotelService.findComments(id,function(datas){
		res.send(datas);
	});
	
});

app.listen(91);