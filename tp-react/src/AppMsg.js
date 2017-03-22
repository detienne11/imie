import React, { Component } from 'react';
import Socketio from 'socket.io-client';

import logo from './logo.svg';
import './App.css';

import UserForm from './UserForm';
import UserList from './UserList';

import MessageForm from './MessageForm';
import MessageList from './MessageList';


const socket = Socketio('http://localhost:3002');

class AppMsg extends Component {
	
	constructor(props) {
	    super(props);
	    this.state = {
	    	user : null,
	    	messageList: [],
	    	users :[],
	    	err: null,
	    };
	}
	
	componentWillMount(){
		console.log("AppMsg : componentWillMount");
		socket.on('connect', function(){});
// socket.emit('msg','connected client')
		
		socket.on('checked', this.handleUserConnected.bind(this));
		socket.on('refreshusers', this.handleRefreshUsers.bind(this));
		socket.on('broadcasting', this.handleBroadCasting.bind(this));
	}
	
	componentDidUnmount()	{
		console.log("AppMsg : componentDidMount");
		socket.on('disconnect', this.state.user);
// socket.emit('msg','disconnected client')
	}
	
	// Validation du Formulaire de login
	handleUserForm(userForm){
		console.log ("handleUserForm",userForm);		
		var user = {
			nickname : userForm.login 
		}; 		
		socket.emit('checkin',user);		
	}	
	
	// Enregistrement du user courant
	handleUserConnected(user,err){
		console.log("handleUserConnected :",user,err);
		if (err == null) {
			this.setState({
				user: user
			});
		}
		else {
			this.setState({
				err: err
			});
		}
	}	
	
	// Refresh de la liste des users
	handleRefreshUsers(users){
		console.log("handleRefreshUsers :",users);
		this.setState({
			users: users
		});
	}
	
	// Refresh de la liste des messages
	handleBroadCasting(msg) {
		console.log("handleBroadCasting :",msg);
		
		if (msg.userid === this.state.user.id){
			msg.ismine = true;
		}
		
		// spread operator
		this.setState({
			messageList: [...this.state.messageList, msg]
		});
	}
			
	handleMessageForm(msgForm){
		console.log ("handleMessageForm :",msgForm);
		
//		// Verification user
//		if (this.state.user == null){			
//			var newuser = {};			
//			newuser.nickname = msgForm.login;			
//			socket.emit('checkin',newuser);
//		}
		
// var newList = this.state.messageList;
// obj.id=newList.length +1;
// newList.push(obj);
// this.setState({messageList:newList});
		
// socket.emit('nick',obj.login)
		
		var message = {
			userid : this.state.user.id,
			id : null,
			text : msgForm.message,
			date : new Date()
		};		
		
		socket.emit('postmsg',message);
		
// socket.on('broadcasting', this.handleBroadCasting.bind(this));
		
		// spread operator
// this.setState({
// messageList: [...this.state.messageList, obj]
// });
	}
	
	render() {
		console.log ("AppMsg new list",this.state.messageList);
		
		if (this.state.user == null) {
			 return (
				      <div className="App">
				      	
				      	<header>
					      	<div className="App-header">
						        <img src={logo} className="App-logo" alt="logo" />
						        <h2>Chat</h2>
						      </div>
				      	</header>
				        <main>
				        	<section>
				        		<p>{this.state.err}</p>
				        		<UserForm onSubmit={this.handleUserForm.bind(this)}/>
			    			</section>		        
				        </main>
				        
				      </div>
				    );
		}
		else {
			 return (
				      <div className="App">
				      	
				      	<header>
					      	<div className="App-header">
						        <img src={logo} className="App-logo" alt="logo" />
						        <h2>Chat</h2>
						      </div>
				      	</header>
				        <main>
				        	<section>
				        		<div className="main-wrapper">
				        			<UserList users={this.state.users} />
				        			<div className="msg-wrapper">
				        				<MessageForm onSubmit={this.handleMessageForm.bind(this)}/>
				        				<MessageList messageList={this.state.messageList} />
				        			</div>
				        		</div>			    				
			    			</section>		        
				        </main>
				        
				      </div>
				    );
		}
	   
  }
}

export default AppMsg;
