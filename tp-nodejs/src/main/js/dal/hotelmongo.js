/**
 * IMPORT EXTERNE
 */
var ObjectID = require('mongodb').ObjectID;
var mongodb = require('mongodb').MongoClient;

/**
 * IMPORT INTERNE
 */
var commentDTO = require('./dto/comment.js');

var datas = require('../../resources/les_hotels_classes_en_ile-de-france.json');

module.exports = { loadHotel, findAll, findById, findByCity, findAvgByCity, findCapacityByCity, addComment, findComments };

var urlCnx = "mongodb://localhost:27017/TestNoSQl";

//function connectMongo(operation) {
//	var url = 'mongodb://localhost:27017/dbtest';
//	MongoClient.connect(urlCnx, operation);
//}

function loadHotel(){
	mongodb.connect(urlCnx, function(err,db){
		for (var index in datas) {
			db.collection('hotels').insert(datas[index]);
		}
		
		if (err){
			return console.log(err);
		}
	});
}

// GET /hotels ===> nom, ville, nombre d'etoiles
function findAll(callback){
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('hotels');
		collection.find({},{"_id" : true,"fields.nom_commercial" : true,"fields.code_postal" : true,"fields.commune" : true,"fields.classement" : true}).toArray(function(err,data){
			
//			console.log(data);
			
			var records = [];
			
			for (var record of data) {
//				console.log(record);
				var obj = {};
				obj.id = record._id;
				obj.nom = record.fields.nom_commercial;
				obj.codepostal = record.fields.code_postal;
				obj.ville = record.fields.commune;
				obj.nbStar =  record.fields.classement;
				records.push(obj);
			}
			
//			console.log(records);
			callback(records);
		});
		
		if (err){
			return console.log(err);
		}
	});

}

// GET /hotel/:id ===> toutes les données
function findById(id,callback){
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('hotels');
		collection.find({_id: ObjectID(id)}).toArray(function(err,data){
//			console.log(data);
			
			var record = null;
			
			if (data != null
					&& data.length == 1){
				record = data[0];
			}
			
			callback(record);
		});
		
		if (err){
			return console.log(err);
		}
	});
	
}

// GET /ville/:codePostal/hotels
function findByCity(codePostal,callback){
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('hotels');
		collection.find({'fields.code_postal' : Number(codePostal)}).toArray(function(err,datas){
			callback(datas);
		});
		
		if (err){
			return console.log(err);
		}
	});
}

//GET /hotels/:codePostal/statisitiques/moyenne (note moyenne sur la ville)
/*


db.hotels.aggregate(
{
    $match: {
        'fields.code_postal': 92400
    }
},{
    $project: {
        _id: '$_id',
        cp:  '$fields.code_postal',
        classement:{ $substr: [ '$fields.classement',0,1]}
    }	
});


 */
function findAvgByCity(codePostal, callback){
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('hotels');
		collection.aggregate([
			{
				$match: {'fields.code_postal': Number(codePostal)}
			},
			{
				$project: {
					cp:'$fields.code_postal',
					classement:{$substr: ['$fields.classement',0,1]}
				}
			}
		]).toArray(function(err,datas){
			
			var total = datas.length;
			
			var nbEtoile = 0;
			
			for (var record of datas){
				
				var test = record.classement.match('(\\d+)');
//				console.log(nbEtoile);		
				if (test){
					nbEtoile += Number(test[1]);
//					console.log('nbEtoile=' + nbEtoile);
				}
			}
			
			var obj = {};
			obj.average = Number(nbEtoile / total);
			callback(obj);
			
//			callback(nbEtoile / total);
		});
		
		if (err){
			return console.log(err);
		}
	});
}

//GET /hotels/:codePostal/statisitiques/capacite (capacité total d'hebergement sur ...
/*

db.hotels.aggregate(
{
    $match: {
        'fields.code_postal': 92400
    }
},{
    $group: {
        _id: '$fields.code_postal',
        total: { $sum: '$fields.capacite_d_accueil_personnes' }
    }	
});

 */
function findCapacityByCity(codePostal,callback){
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('hotels');
		collection.aggregate([
			{
				$match: {'fields.code_postal': Number(codePostal)}
			},
			{
				$group: {
					_id: '$fields.code_postal',
					total: { $sum: '$fields.capacite_d_accueil_personnes' }
				}
			}
		]).toArray(function(err,data){
			
			var capacityTotal = 0;
			console.log(data);
			if (data != null
					&& data.length == 1){
				console.log(data[0].total);
				capacityTotal = Number(data[0].total);
			}
			
			var obj = {};
			obj.capacity = Number(capacityTotal);
			callback(obj);
			
//			callback(capacityTotal);
		});
		
		if (err){
			return console.log(err);
		}
	});

}

function addComment(comment,callback) {
	mongodb.connect(urlCnx, function(err,db){
		var collection = db.collection('comments');

		console.log(comment);
		
		collection.insert(comment);
		
		callback(err);
		
//		{'hotel.id' : hotelId},{'hotel.db' : 'TestNoSQl'},{'hotel.ref' : 'hotels'}
		
//		var obj = {};
//		obj.author = author;
//		obj.date = date;
//		obj.content = content;
//		obj.hotelId = hotelId;
//		

	});
}

function findComments(hotelId,callback){
	
	mongodb.connect(urlCnx, function(err,db){
		
		var collection = db.collection('comments');
		collection.find({'hotel._id' : ObjectID(hotelId)}).toArray(function(err,datas){
			console.log(datas);
			callback(datas);
		});
		
		if (err){
			return console.log(err);
		}
	});	
}
