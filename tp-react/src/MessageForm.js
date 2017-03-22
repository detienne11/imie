import React, { Component } from 'react';

class MessageForm extends Component {
	
	constructor(props) {
	    super(props);
	    this.state = {
	    	login: '',
	    	message: ''	    		
	    };	    
	    
	    this.handleInputChange = this.handleInputChange.bind(this);
	    this.handleSubmit = this.handleSubmit.bind(this);
	  }
  
	  handleInputChange(event) {
		    const target = event.target;
		    const name = target.name;

		    this.setState({
		      [name]: event.target.value
		    });
		  }

	  handleSubmit(event) {
	    console.log('Submit message: ',this.state);
	    event.preventDefault(); // empeche le comportement normal du form(envoi)
	    this.props.onSubmit(this.state);
	    this.setState({
	    	message :''
	    });
	    
	  }
	  
//      <label>
//      Name:
//      	<input id="login" type="text" name="login" placeholder="Entrez votre login"  value={this.state.login} onChange={this.handleInputChange}/>
//		
//    </label>
	  
	render() {			
	    return (
	    		<div className="msg-form">
	    			<form onSubmit={this.handleSubmit}>
	    				<input type="text" name="message" placeholder="Entrez votre message" value={this.state.message} onChange={this.handleInputChange} width="200px" />
	    				<input type="submit" value=">" />
	    	    </form>
	    	  </div>
	    );
	}
}

MessageForm.propTypes = {
	onSubmit : React.PropTypes.func.isRequired
}


export default MessageForm;
