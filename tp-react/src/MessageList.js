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
	        		<div>
	        			{messages.map((msg) => (	        		
	        				<Message key={msg.id} message={msg} />
	        			))}
	        		</div>
	        );
	    }
	    else return [];
	}
	
	render() {
		
//		destructureur
//		const {messages} =  this.state;
		
		const messages = this.renderMessage(this.props.messageList);
	        
	    return (
			<div className="msg-list">
            	{ messages }			
			</div>
	    );
	}
}

MessageList.propTypes = {
	messageList : React.PropTypes.array.isRequired
}

export default MessageList;
