import React, { Component } from 'react';

class Test extends Component {
	
	constructor(props){
		super(props);
		this.state = {
				counter :0
		};
	}
	
	handleClickButton() {
		console.log("Click",this);
		this.setState({
			counter : this.state.counter +1 
		});
		
	}
	
	render() {			
    return (
		<div>
			<span id="counter">{this.state.counter}</span>
			<button type="button" onClick={this.handleClickButton.bind(this)}>+</button>
		</div>
    );
  }
}

export default Test;
