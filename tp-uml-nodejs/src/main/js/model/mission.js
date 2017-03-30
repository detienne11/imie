
module.exports = {Mission};

/**
 * Mission Object
 */
function Mission(){
    this.beginDate = null;
    this.endDate = null;
    this.employees = [];
};

/**
 * GETTERs & SETTERs
 */
Mission.prototype.getBeginDate = function(){
	return this.beginDate;
};

Mission.prototype.setBeginDate = function(value){
	this.beginDate = value;
};

Mission.prototype.getEndDate = function(){
	return this.endDate;
};

Mission.prototype.setEndDate = function(value){
	this.endDate = value;
};

Mission.prototype.getEmployees = function(value){
	this.employees = value;
};

Mission.prototype.setEmployees = function(){
	return this.employees;
};

Mission.prototype.addEmployee = function(item){
	this.employees.push(item);
};

Mission.prototype.delEmployee = function(item){
    console.log("Mission : delEmployee not implemented");
};