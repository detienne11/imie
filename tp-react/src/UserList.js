import React, { Component } from 'react';
import User from './User';

class UserList extends Component {

	
	renderDatas(datas) {
		console.log("UserList :",datas);

	    if (datas.length > 0) {
	    	
	        return (
	        		<div>
	        			{datas.map((data) => (	        		
	        				<User key={data.id} user={data} />
	        			))}
	        		</div>
	        );
	    }
	    else return [];
	}
	
	render() {
		
		const users = this.renderDatas(this.props.users);
	        
	    return (
	    	<div className="user-wrapper">				
            	{ users }			
			</div>
	    );
	}
}

UserList.propTypes = {
	users : React.PropTypes.array.isRequired
}

export default UserList;
