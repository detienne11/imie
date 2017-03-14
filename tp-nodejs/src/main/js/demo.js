/**
 * IMPORT EXTERNE
 */
var express = require('express') ;
var path = require('path') ;
var bodyParser = require('body-parser');

/**
 * IMPORT INTERNE
 */
var demoService = require('./dal/demodb.js');
var MessageDTO = require('./dal/dto/message.js').Message;
var PingMessageDTO = require('./dal/dto/pingMessage.js').PingMessage;

/**
 * CONFIG APP.JS
 */
var app = express() ;
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extened: true}));
app.set('views',path.join(__dirname,'../webapp/views'));
app.set('view engine','ejs');

app.get('/', function (req, res) {
	console.log('url=/');	
	res.render('demo');
});

// GET /hello-world
app.get('/hello-world', function (req, res) {
	console.log('url=/hello-world');
	res.send('Hello World !!');
});

//GET /coucou/:name
app.get('/coucou/:name', function (req, res) {
	console.log('url=/coucou/:name');
	var name = req.params.name;
	console.log(name);
	res.render('coucou',{name});
});

// GET /ping?message=text
app.get('/ping', function (req, res) {
	console.log('url=/ping?message=text');
	
	var test = req.url.match('.*\?message=(.*)&?');
	var query = req.query.message;
	console.log(query);
	
	if (test) {
	
		var content = test[1];
		console.log('content=' + content);
		
		var msg = new PingMessageDTO(content);
		console.log(msg);
		demoService.addPingMessage(msg,function(err){
			if (err){
				res.send('Exo 3 Failed');
			}
			else {
				res.send('OK');
			}
		});
		
	}
	else {
		res.send('Url invalid pattern : /ping?message=text');
	}
		
});

// POST /message
app.post('/message', function (req, res) {
	console.log('url=/message');
	
	var author = req.body.author;
	var content = req.body.content;
	
	var msg = new MessageDTO();
	msg.setAuthor(author);
	msg.setContent(content);
	
	demoService.addMessage(msg,function(err){
		if (err){
			res.send('Exo 4 Failed');
		}
		else {
			res.send('OK');
		}
	});
	
});

// GET /messages
app.get('/messages', function (req, res) {
	console.log('url=/messages');

	demoService.findMessages(function(datas){
		res.send(datas);
//		res.render('messages',{datas});
	});
	
});

// GET /message/:auteur
app.get('/message/:auteur', function (req, res) {
	console.log('url=/message/:auteur');
	
	var author = req.params.auteur;
	demoService.findMessagesByAuthor(author, function(datas){
		res.send(datas);
//		res.render('messagesByAuthor',{datas});
	});
});

app.listen(92);