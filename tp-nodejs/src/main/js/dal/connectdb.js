//npm install mogodb
var db = require('mongodb').MongoClient;

db.connect("mongodb://localhost:27017/TestNoSQl", function(err,db){
		if (err){
			return console.log(err);
		}});

var collection = db.collection('test');
Console.log(Collection.find());
// w:1 : permet d'tere sur que l'insertion se passe sur la base
//Collection insert(docs,{w:1},function(err,result){});