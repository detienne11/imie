/**
 * IMPORT EXTERNE
 */
var mongodb = require('mongodb').MongoClient;

module.exports = { addPingMessage, addMessage, findMessages, findMessagesByAuthor };

var urlCnx = "mongodb://localhost:27017/TestNoSQl";

function addPingMessage(message,callback){
	console.log('addPingMessage');
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('ping');
		console.log(message);
		
		collection.insert(message);
		
		callback(err);
	});
}

function addMessage(message, callback){
	console.log('addMessage');
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('message');
		console.log(message);
		
		collection.insert(message);
		
		callback(err);
	});
}

function findMessages(callback){
	console.log('findMessages');
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('message');
		collection.find({}).toArray(function(err,datas){
			callback(datas);
		});
		
		if (err){
			return console.log(err);
		}
	});
	
}

function findMessagesByAuthor(author,callback){
	console.log('findMessagesByAuthor');
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('message');
		collection.find({'author' : author}).toArray(function(err,datas){
			callback(datas);
		});
		
		if (err){
			return console.log(err);
		}
	});
}
