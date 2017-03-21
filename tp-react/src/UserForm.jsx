import React, { Component } from 'react';

class UserForm extends Component {
	
	constructor(props) {
	    super(props);
	    this.state = {
	    	login: ''	    		
	    };
	    
	    this.handleChange = this.handleChange.bind(this);
	    this.handleSubmit = this.handleSubmit.bind(this);
	  }
	  
	// Saisie dans le champ login 
	  handleChange(event) {
		  this.setState({
			  login: event.target.value
		});
	  }

	  // submit du login
	  handleSubmit(event) {
	    console.log('UserForm submit : ',this.state);
	    event.preventDefault(); // empeche le comportement normal du form(envoi)
	    
	    this.props.onSubmit(this.state);
	    
	    this.setState({
	    	login :''
	    });
	    
	  }
	  
	render() {			
	    return (
	    		<form onSubmit={this.handleSubmit}>
	    	      <label>Login :
	    	    	  <input type="text" name="login" placeholder="Entrez votre login" value={this.state.login} onChange={this.handleChange}/>					
	    	      </label>	    	      
	    	      <input type="submit" value="Checkin" />
	    	    </form>
	    );
	}
}

UserForm.propTypes = {
	onSubmit : React.PropTypes.func.isRequired
}

export default UserForm;
