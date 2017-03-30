module.exports = {Training};

/**
 * Training Object
 */
function Training(){
    this.name = null;
    this.topic = null;
    this.days = null;
    this.candidates = [];
};

/**
 * GETTERs & SETTERs
 */
Training.prototype.getName = function(){
	return this.name;
};

Training.prototype.setName = function(value){
	this.name = value;
};

Training.prototype.getTopic = function(){
	return this.topic;
};

Training.prototype.setTopic = function(value){
	this.topic = value;
};

Training.prototype.getDays = function(){
	return this.days;
};

Training.prototype.setDays = function(value){
	this.days = value;
};

Training.prototype.getCandidates = function(value){
	this.candidates = value;
};

Training.prototype.setCandidates = function(){
	return this.candidates;
};

Training.prototype.addCandidate = function(item){
	this.candidates.push(item);
};

Training.prototype.delCandidate = function(item){
	console.log("Training : delCandidate not implemented");
};


