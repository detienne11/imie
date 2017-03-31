module.exports = {Training};

/**
 * Training Object
 */
function Training(){
	this.id = null;
    this.name = null;
    this.topic = null;
    this.days = null;
    this.candidates = [];
};

/**
 * GETTERs & SETTERs
 */
Training.prototype.getId = function(){
	return this.id;
};

Training.prototype.setId = function(value){
	this.id = value;
};

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

// Training.prototype.setCandidates = function(){
// 	return this.candidates;
// };

Training.prototype.addCandidate = function(item){
	this.candidates.push(item);
};

Training.prototype.delCandidate = function(item){
	let indexOf = this.candidates.findIndex(elt => {return elt.id === item.id;});
    if (indexOf != -1) {
        let removed = this.candidates.splice(indexOf, 1);
        console.log("Training : candidate item removed",removed);
	}
	else {
		 console.log("Training : delCandidate - candidate item unfounded",item);
	}
};

/**
 * METHODs
 */

/**
 * Register Candidate
 * @param Training
 */
Training.prototype.register = function(candidate){
	console.log("Training : register",candidate);
    this.addCandidate(candidate);
	candidate.notifyRegister(this); 
};

/**
 * Unregister Candidate
 * @param Training
 */
Training.prototype.unregister = function(candidate){
	console.log("Training : unregister",candidate);
    this.delCandidate(candidate);
	candidate.notifyUnregister(this); 
};
