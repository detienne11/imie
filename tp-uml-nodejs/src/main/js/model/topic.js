module.exports = {Topic};

/**
 * Topic Object
 */
function Topic(){
    this.id = null;
	this.name = null;
};

/**
 * GETTERs & SETTERs
 */
Topic.prototype.getId = function(){
	return this.id;
};

Topic.prototype.setId = function(value){
	this.id = value;
};

Topic.prototype.getName = function(){
	return this.name;
};

Topic.prototype.setName = function(value){
	this.name = value;
};