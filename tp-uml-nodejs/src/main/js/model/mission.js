module.exports = {Mission};

/**
 * Mission Object
 */
function Mission(){
	this.id = null;
    this.beginDate = null;
    this.endDate = null;
    this.employees = [];
};

/**
 * GETTERs & SETTERs
 */
Mission.prototype.getId = function(){
	return this.id;
};

Mission.prototype.setId = function(value){
	this.id = value;
};

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

// Mission.prototype.setEmployees = function(){
// 	return this.employees;
// };

Mission.prototype.addEmployee = function(item){
	this.employees.push(item);
};

Mission.prototype.delEmployee = function(item){
    let indexOf = this.employees.findIndex(elt => {return elt.id === item.id;});
    if (indexOf != -1) {
        let removed = this.employees.splice(indexOf, 1);
        console.log("Mission : employee item removed",removed);
	}
	else {
		 console.log("Mission : delEmployee - employee item unfounded",item);
	}
};

/**
 * Assign Employee
 * @param Employee
 */
Mission.prototype.assign = function(employee){
	console.log("Mission : assign",employee);
    this.addEmployee(employee);
	employee.notifyAssign(this); 
};

/**
 * Detach Employee
 * @param Employee
 */
Mission.prototype.detach = function(employee){
	console.log("Mission : detach",employee);
    this.delEmployee(employee);
	employee.notifyDetach(this); 
};