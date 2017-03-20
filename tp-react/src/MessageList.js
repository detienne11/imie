import React, { Component } from 'react';
import Message from './Message';

class MessageList extends Component {
	
//	constructor(props) {
//	    super(props);
//	    console.log("MessageList",this.props.messageList);
//	}
	
	renderMessage(messages) {
		console.log("MessageList liste de messages :",messages);

	    if (messages.length > 0) {
	    	
	        return (
	        		<ul>
	        			{messages.map((msg) => (	        		
	        				<Message key={msg.id} message={msg} />
	        			))}
	        		</ul>
	        );
	    }
	    else return [];
	}
	
	render() {
		
		const messages = this.renderMessage(this.props.messageList);
	        
	    return (
			<div>
				<h2>MessageList</h2>
            	{ messages }
				<textarea id="console" style={{height: 250,width:200}}></textarea>				
			</div>
	    );
	}
}

export default MessageList;
