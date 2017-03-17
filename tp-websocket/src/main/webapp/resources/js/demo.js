
var socket = new WebSocket("ws://localhost:8091/tp-websocket/demo");

function send() {
	console.log("Send Data ...");
	
	var data = {
		a: 100,
		b: "coucou"
	};
	
	socket.send(JSON.stringify(data));
	
//	socket.send("coucou");
}

socket.onmessage= function(event){
	console.dir(event);
	console.log(event.data);
	var data = JSON.parse(event.data);
	console.log(data.c);
	console.log(data.d);
}