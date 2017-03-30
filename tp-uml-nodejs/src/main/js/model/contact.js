module.exports = {Contact};

/**
 * Contact Object
 */
function Contact(){
    this.address = null;
	this.phone = null;
};

/**
 * GETTERs & SETTERs
 */
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