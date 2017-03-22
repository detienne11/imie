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
		
		let style = "msg-item-me";
		
		if (this.state.message.ismine == null) {
			style = "msg-item";
		}
//		console.log(style);
		
	    return (
	    	<div className={style}>
	    		<div className="msg-text">{this.state.message.text}</div>
	    		<div className="msg-date">{this.state.message.date}</div>
	    		{/*this.state.message.userid} - {this.state.message.id*/}  
			</div>
	    );
	}
}


Message.propTypes = {
	message : React.PropTypes.object.isRequired
}

export default Message;
