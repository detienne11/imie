module.exports = {Employee};

/**
 * Employee Object
 */
function Employee(){
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

Employee.prototype.setMissions = function(){
	return this.missions;
};

Employee.prototype.addMission = function(item){
	this.missions.push(item);
};

Employee.prototype.delMission = function(item){
    console.log("Employee : delMission not implemented");
};

Employee.prototype.getTrainings = function(value){
	this.trainings = value;
};

Employee.prototype.setTrainings = function(){
	return this.trainings;
};

Employee.prototype.addTraining = function(item){
	this.trainings.push(item);
};

Employee.prototype.delTraining = function(item){
    console.log("Employee : delTraining not implemented");
};

/**
 * METHODs
 */

/**
 * Subscribe Training
 * @param Training
 */
Employee.prototype.subscribe = function(training){
	console.log("Employee : subscribe",training);
    this.addTraining(training);
};

/**
 * Realize Mission
 * 
 * @param Mission
 */
Employee.prototype.realize = function(mission){
	console.log("Employee : realize",mission);
    this.addMission(mission);
};


