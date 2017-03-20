import React, { Component } from 'react';

class MessageForm extends Component {
	
	constructor(props) {
	    super(props);
	    this.state = {
	    		login:'dav',
	    		message: '',	    		
	    		};	    
	    
//	    this.handleChange = this.handleChange.bind(this);
	    this.handleInputChange = this.handleInputChange.bind(this);
	    this.handleSubmit = this.handleSubmit.bind(this);
	  }

//	  handleChange(event) {
//	    this.setState({value: event.target.value});
//	  }
	  
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
	  
	render() {			
	    return (
	    		  <form onSubmit={this.handleSubmit}>
	    	      <label>
	    	        Name:
	    	        	<input id="login" type="text" name="login" placeholder="Entrez votre login"  value={this.state.login} onChange={this.handleInputChange}/>
					
	    	      </label>
	    	      <label>
	    	        Message :
	    	        	<input type="text" name="message" placeholder="Entrez votre message"  value={this.state.message} onChange={this.handleInputChange} />
		    	  </label>  
	    	      <input type="submit" value="Submit" />
	    	    </form>
	    );
	}
}

MessageForm.propTypes = {
	onSubmit : React.PropTypes.func.isRequired
}


export default MessageForm;
