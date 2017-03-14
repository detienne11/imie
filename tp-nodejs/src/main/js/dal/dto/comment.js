/**
 * IMPORT EXTERNE
 */
//var ObjectID = require('mongodb').ObjectID;
var mongodb = require('mongodb');

module.exports = {Comment};

function Comment(){
	this.author = null;
	this.date = null;
	this.content = null;
};

Comment.prototype.getAuthor = function(){
	return this.author;
};

Comment.prototype.setAuthor = function(value){
	this.author = value;
};


Comment.prototype.getDate = function(){
	return this.date;
};

Comment.prototype.setDate = function(value){
	this.date = value;
};

Comment.prototype.getContent = function(){
	return this.content;
};

Comment.prototype.setContent = function(value){
	this.content = value;
};

Comment.prototype.setHotelId = function(hotelid){
	if (this.hotel == null){
		this.hotel = {};
	};
//	this.hotel._id = new ObjectID(hotelid);
	this.hotel._id = new mongodb.ObjectID(hotelid);
	this.hotel.$ref = 'hotels';
	this.hotel.db = 'TestNoSQl';
};

