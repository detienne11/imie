import React, { Component } from 'react';

class User extends Component {
	
	constructor(props) {
//		console.log("User :",props);
	    super(props);
	    this.state = {
	    	user: this.props.user	    		
	    };
	}
	
	render() {			
	    
		let user = this.state.user;
		console.log("User",user);
		
		if (user == null){
			user = {};
		}
		
		return (
			<div className="user-item">
				<div className="user-name">{user.nickname}</div>
				<div className="user-desc"></div>
			</div>
	    );
	}
}


User.propTypes = {
	user : React.PropTypes.object.isRequired
}

export default User;
