import React, { Component } from 'react';

class Message extends Component {
	
	constructor(props) {
		console.log("Message :",props);
	    super(props);
	    this.state = {
	    	message: this.props.message	    		
	    };
	}
	
	render() {			
	    return (
			<li>			
			{this.state.message.id} : {this.state.message.login} - {this.state.message.message} 
			</li>
	    );
	}
}


Message.propTypes = {
		message : React.PropTypes.object.isRequired
}

export default Message;
