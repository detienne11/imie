import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import MessageList from './MessageList';
import MessageForm from './MessageForm';

class AppMsg extends Component {
	
	constructor(props) {
	    super(props);
	    this.state = {
	    	messageList: []	    		
	    };
	}
	
	handleCallbackMessageForm(obj){
		console.log ("AppMsg add Message",obj);
		var newList = this.state.messageList;
		obj.id=newList.length +1;
//		newList.push(obj);
//		this.setState({messageList:newList});
		
		// spread operator
		this.setState({
			messageList: [...this.state.messageList, obj]
		});

	}
	
	render() {
		console.log ("AppMsg new list",this.state.messageList);	
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
		        	<MessageList messageList={this.state.messageList} />
					<MessageForm onSubmit={this.handleCallbackMessageForm.bind(this)}/>
	        	</section>
	        </main>        
	      </div>
	    );
  }
}

export default AppMsg;
