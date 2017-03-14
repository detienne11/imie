/**
 * Message Object
 */

module.exports = {Message};

function Message(){
	this.author = null;
	this.content = null;
};

Message.prototype.getAuthor = function(){
	return this.author;
};

Message.prototype.setAuthor = function(value){
	this.author = value;
};

Message.prototype.getContent = function(){
	return this.content;
};

Message.prototype.setContent = function(value){
	this.content = value;
};
