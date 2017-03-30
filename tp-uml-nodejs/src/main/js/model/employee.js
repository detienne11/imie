module.exports = {Employee};

/**
 * Employee Object
 */
function Employee(){
	this.id = null;
    this.name = null;
    this.firstname = null;
	this.pay = null;
    this.contact = null;
    this.missions = [];
    this.trainings = [];
};

/**
 * GETTERs & SETTERs
 */
Employee.prototype.getId = function(){
	return this.id;
};

Employee.prototype.setId = function(value){
	this.id = value;
};

Employee.prototype.getName = function(){
	return this.name;
};

Employee.prototype.setName = function(value){
	this.name = value;
};

Employee.prototype.getFirstname = function(){
	return this.firstname;
};

Employee.prototype.setFirstname = function(value){
	this.firstname = value;
};

Employee.prototype.getPay = function(){
	return this.pay;
};

Employee.prototype.setPay = function(value){
	this.pay = value;
};

Employee.prototype.getContact = function(){
	return this.contact;
};

Employee.prototype.setContact = function(value){
	this.contact = value;
};

Employee.prototype.getMissions = function(value){
	this.missions = value;
};

// Employee.prototype.setMissions = function(){
// 	return this.missions;
// };

Employee.prototype.addMission = function(item){
	this.missions.push(item);
};

Employee.prototype.delMission = function(item){
	let indexOf = this.missions.findIndex(elt => {return elt.id === item.id;});
    if (indexOf != -1) {
        let removed = this.missions.splice(indexOf, 1);
        console.log("Employee : mission item removed",removed);
	}
	else {
		console.log("Employee : delMission - mission item unfounded",item);
	}
};

Employee.prototype.getTrainings = function(value){
	this.trainings = value;
};

// Employee.prototype.setTrainings = function(){
// 	return this.trainings;
// };

Employee.prototype.addTraining = function(item){
	this.trainings.push(item);
};

Employee.prototype.delTraining = function(item){
    let indexOf = this.trainings.findIndex(elt => {return elt.id === item.id;});
    if (indexOf != -1) {
        let removed = this.trainings.splice(indexOf, 1);
        console.log("Employee : training item removed",removed);
	}
	else {
		 console.log("Employee : delTraining - training item unfounded",item);
	}
};

/**
 * METHODs
 */

/**
 * Register Training
 * @param Training
 */
Employee.prototype.register = function(training){
	console.log("Employee : register",training);
	training.register(this);	
};

/**
 * NotifyRegister Training
 * @param Training
 */
Employee.prototype.notifyRegister = function(training){
	console.log("Employee : notifyRegister",training);    
	this.addTraining(training);	
};

/**
 * Unregister Training
 * @param Training
 */
Employee.prototype.unregister = function(training){
	console.log("Employee : unregister",training);    
	training.unregister(this);
};

/**
 * NotifyUnregister Training
 * @param Training
 */
Employee.prototype.notifyUnregister = function(training){
	console.log("Employee : notifyUnregister",training);
	this.delTraining(training);
};

/**
 * Assign Mission
 * @param Mission
 */
Employee.prototype.assign = function(mission){
	console.log("Employee : assign",mission);
	mission.assign(this);
};

/**
 * NotifyAssign Mission
 * @param Mission
 */
Employee.prototype.notifyAssign = function(mission){
	console.log("Employee : notifyAssign",mission);
	this.addMission(mission);
};

/**
 * Detach Mission
 * @param Mission
 */
Employee.prototype.detach = function(mission){
	console.log("Employee : detach",mission);
    mission.detach(this);
};

/**
 * NotifyDetach Mission
 * @param Mission
 */
Employee.prototype.notifyDetach = function(mission){
	console.log("Employee : notifyDetach",mission);    
	this.delMission(mission);
};


