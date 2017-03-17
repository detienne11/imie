
var uri = 'ws' + document.location.href.match(/:.*\//)[0];
console.log(uri);
	
// ws://localhost:8091/tp-websocket/chat
var socket = new WebSocket(uri + "/chat");

function send() {

	console.log("Send Data ...");

	var login = document.getElementById('login');
	var message = document.getElementById('message');

	console.log("Send Msg : login=" + login.value + ", Msg=" + message.value);

	var data = {
		login : login.value,
		message : message.value
	};

	socket.send(JSON.stringify(data));
}

socket.onmessage = function(event) {

//	console.dir(event);
//	console.log(event.data);

	var data = JSON.parse(event.data);
//	console.log(data.login);
//	console.log(data.message);

	var display = document.getElementById('console');

	display.textContent = display.textContent + '\n' + data.login + ", Msg=" + data.message;

}