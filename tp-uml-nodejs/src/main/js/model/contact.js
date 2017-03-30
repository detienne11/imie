module.exports = {Contact};

/**
 * Contact Object
 */
function Contact(){
	this.id = null;
    this.address = null;
	this.phone = null;
};

/**
 * GETTERs & SETTERs
 */
Contact.prototype.getId = function(){
	return this.id;
};

Contact.prototype.setId = function(value){
	this.id = value;
};

Contact.prototype.getAddress = function(){
	return this.address;
};

Contact.prototype.setAddress = function(value){
	this.address = value;
};

Contact.prototype.getPhone = function(){
	return this.phone;
};

Contact.prototype.setPhone = function(value){
	this.phone = value;
};