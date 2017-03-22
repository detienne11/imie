import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Test from './Test';

class App extends Component {
  
	constructor(props){
		super(props);
		console.log("App : constructor");
		console.log("App: props", props);
	}
	
	componentWillMount(){
		console.log("App : componentWillMount");
	}
	
	componentDidMount()	{
		console.log("App : componentDidMount");
	}
	
	render() {
			
		console.log("App : render");
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2 style={{color: this.props.color}}>Salut to React</h2>
        </div>
        <p className="App-intro">
        	<Test />
        </p>
      </div>
    );
  }
}

export default App;
