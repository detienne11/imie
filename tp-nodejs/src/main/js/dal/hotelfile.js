var file = require('../../resources/les_hotels_classes_en_ile-de-france.json');

module.exports = { findAll,findById,findByCity,findAvgByCity,findCapacityByCity};

//GET /hotels ===> nom, ville, nombre d'etoiles
function findAll(){
	
	var records = [];
	for ( var record of file) {
		
		var obj = {};
		obj.id = record.recordid;
		obj.nom =  record.fields.nom_commercial;
		obj.codepostal =  record.fields.code_postal;
		obj.ville = record.fields.commune;
		obj.nbStar =  record.fields.classement;
		
		records.push(obj);
	}
//	console.log(records);
	return records;
}

//GET /hotel/:id ===> toutes les données
function findById(id){
	var hotel = null;
	for ( var record of file) {		
		if (record.recordid == id){
			hotel = record;
			break;
		}
	}
//	console.log(hotel);
	return hotel;
}

// GET /ville/:codePostal/hotels 
function findByCity(codePostal){
	var records = [];
	for ( var record of file) {		
		if (record.fields.code_postal == codePostal){
			records.push(record);			
		}
	}
//	console.log(records);
	return records;
}

// GET /hotels/:codePostal/:distance (recherche les hotels à une distance inférieure ...

// GET /hotels/:codePostal/statisitiques/moyenne (note moyenne sur la ville)
function findAvgByCity(codePostal){
	
	var records = findByCity(codePostal);
	
	var total = records.length;
	
	var nbEtoile = 0;
	
	for (var record of records){
		
		var test = record.fields.classement.match('(\\d{1}).*');
		console.log(nbEtoile);		
		if (test){
			nbEtoile += Number(test[1]);
			console.log('nbEtoile=' + nbEtoile);
		}
	}
	
	return nbEtoile / total;
	
}

// GET /hotels/:codePostal/statisitiques/capacite (capacité total d'hebergement sur ...
function findCapacityByCity(codePostal){
	
	var records = findByCity(codePostal);
	
	var capacityTotal = 0;
	
	for (var record of records){
		var value = record.fields.capacite_d_accueil_personnes;
		var capacity = 0;
		if (value != null){
			capacity = Number(record.fields.capacite_d_accueil_personnes);
		}		
		console.log('capacity=' + capacity);
		
		capacityTotal += capacity;
		console.log('capacityTotal=' + capacityTotal);
	}
	
	return capacityTotal;	
}

