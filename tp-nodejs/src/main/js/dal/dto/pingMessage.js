/**
 * PingMessage Object
 */

module.exports = {PingMessage};

function PingMessage(content){
	this.content = content;
	this.date = new Date();
};
