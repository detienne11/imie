
	var game = new Game();

	var sortirTaupe = [];
	var img = 'resources/img/6995-l_square.jpg';
	
	// Counter
	function Counter(){
		this.value = 0;
	}
	
	Counter.prototype.getValue=function(){ return this.value;}
	Counter.prototype.increase=function(value){
		this.value += Number(value);
		var counter = document.getElementById("counter");
		counter.textContent = this.value;
		console.log("Counter = " + this.value);
	}
	
	// Taupe
	function Taupe(){
		this.id = null;
		this.gridSize = 0;
		this.position = -1;
		this.state = 0;
		this.timeToOut = 700;
		this.timeToMove = 1000;		
	};
	
	Taupe.prototype.getState = function(){
		return this.state;
	};	
	Taupe.prototype.setState = function(state){
		this.state = state;
	};
	
	Taupe.prototype.lacher = function(){
		timerDeplacerTaupe(this.id);
	}
	
	Taupe.prototype.deplacer = function(){

		// calcul position aléatoire
		var position = Math.floor((Math.random() * this.gridSize) + 1);
		console.log("Random Position=" + position);
		
		this.position = position;
		console.log("deplacer case=" + position);
		
		var cell = document.getElementById(position);
		cell.className="show";
		this.setState(1);
		setTimeout("timerRentrerTaupe(" + this.id + "," + position + ")",this.timeToOut);		
	};
	
	Taupe.prototype.taper= function(){
		console.log("taper");
//		counter.increase(100);
	};
	
	// Game
	function Game() {
		this.gameBoard = null;
		this.gridSize = 8;
		this.counter = new Counter();
		this.taupeList = [];
	}
	
	Game.prototype.load = function (){
		
		console.log("Load game");
		
		// Plateau du jeu
		var gameBoard = document.getElementById('gameBoard');
		
		// taille de la grille
		
		var gridSize = document.getElementById('grid.size');		
		if (gridSize != null
				&& gridSize.value != ""){
			this.gridSize  = Number(gridSize.value);
		}
		var size = this.gridSize;

		if (gameBoard.children.length > 0){
			gameBoard.removeChild(gameBoard.firstChild);
		}
		
		var div = document.createElement('div');
		div.className = "grid";
		
		var grid = document.createElement('table');
		for (var i = 0; i < size; i++) {
			var row = grid.insertRow();
			for (var j = 0; j < size; j++) {
				var cell = row.insertCell();
				cell.id= (i*size) + j + 1;
				cell.className="hide";
				cell.addEventListener('click', addEventCell);
			}
		}
		div.appendChild(grid);

		gameBoard.appendChild(div);
		this.gameBoard = gameBoard;
	}
	
	Game.prototype.start = function (){
		
		console.log("Start game");
		
		// lacher de taupes
		var taupe = new Taupe();
		var index = this.taupeList.push(taupe);
		console.log(this.taupeList);
		taupe.id = index;
		taupe.gridSize = this.gridSize * this.gridSize;
		console.log(taupe);
		taupe.lacher();
		
	}
	
	var timerDeplacerTaupe = function(taupeId){
		console.log("timerDeplacerTaupe");
		console.log(taupeId);
		var taupe = game.taupeList[taupeId-1];
		taupe.deplacer();
	}
	
	//
	var timerRentrerTaupe = function(taupeId,position){
		
		console.log("timerRentrerTaupe");
		console.log(taupe);
		
		var trou = document.getElementById(position);
		if (trou != null){
			trou.className="hide";
//			taupe.setState(0);
			console.log("Hide ");
			
			// deplacer
			var taupe = game.taupeList[taupeId-1];
			console.log(taupeId);
			setTimeout("timerDeplacerTaupe(" + taupeId + ")",2000);
			
//			console.log(taupe);
		}	
	}
	
	function startGame() {
		game.load();
		game.start();
		console.log(game);
	}
	
	function addEventCell(e) {
		e = e || window.event;
		var target = e.target || e.srcElement;
		if (e.type == 'click'){	
	//		console.log(target.textContent);
			selectCase(target);
		}
	}

	function selectCase(elt) {	
		if (elt != null){
			if (elt.className == "show") {
//				elt.className="show";
				var counter = game.counter.increase(100);
			}
//			else {
//				elt.className="hide";
//			}
			
		}
	}
