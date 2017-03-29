/**
 * IMPORT EXTERNE
 */
var server = require('http').createServer();
var io = require('socket.io')(server);
var uuidV4 = require('uuid/v4');

var users = [];

io.on('connection', function(client){
	
	console.log("connection event");
//	console.log("new connection :",client);	
	
	// Inscription nouvel utilisateur
	client.on('checkin', function(user){
		
		var err = null;
		
		var exist = false;
		for (var u of users) {
			console.log(u);
			if (u.nickname == user.nickname) {
				exist = true;
			}
		}
		
		if (!exist) {
			user.id = uuidV4();
			users.push(user);
		}
		else {
			err = 'login déjà utilisé';
		}
		client.emit('checked',user,err);
		
		if (!exist) {
			io.sockets.emit('refreshusers',users);
		}
		
		console.log("Checkin event : New user=",user);
		
	});
	
	// Nouveau Message
	client.on('postmsg', function(data){

	  data.id = uuidV4();
	  console.log("postmsg event : Receive msg=",data);
	  io.sockets.emit('broadcasting',data);
 	});
	
//	client.on('msg', messageReceive.bind(this));
	
	// deconnexion
	client.on('disconnect', function(user){
		console.log(client);
	  console.log('disconnect event : user=', user);
	  io.sockets.emit('deluser',user);
  	});
});

function messageReceive (data) {
	console.log("messageReceive: data=",data);	
}

server.listen(3002);