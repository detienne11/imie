
	
	
	// Counter
	function Counter(){
		this.value = 0;
	}
	
	Counter.prototype.getValue=function(){ return this.value;}
	Counter.prototype.setValue=function(value){ this.value = value;}
	Counter.prototype.increase=function(value){
		this.value += Number(value);
	}
	
	Counter.prototype.decrease=function(value){
		this.value = this.value - Number(value);
	}
	
	// Taupe
	function Taupe(){
		this.id = null;
		this.img = null;
		this.gridSize = 0;
		this.game = null;
		this.position = -1;
		this.state = -1; // -1 : Prison, 0: Free, 1: Sort, 2:  Rentre
		this.killer = false;
		this.timeToOut = 1000;
		this.timeToMove = 1000;		
	};
	
	Taupe.prototype.getPosition = function(){
		return this.position;
	};	
	Taupe.prototype.setPosition = function(position){
		this.position = position;
	};
	
	Taupe.prototype.getState = function(){
		return this.state;
	};	
	Taupe.prototype.setState = function(state){
		this.state = state;
	};
	
	Taupe.prototype.init = function () {
		this.img = document.createElement('img');
		this.img.src = 'resources/img/mole.png';
	}

	Taupe.prototype.addEventTaupe = function (e) {
		e = e || window.event;
		var target = e.target || e.srcElement;
		if (e.type == 'click'){	
			this.taper();
		}
	}
	
	Taupe.prototype.liberer = function (){
		console.log("Liberer Taupe");
		this.setState(0);
		this.img.addEventListener('click', this.addEventTaupe.bind(this));
		this.deplacer();		
	}
	
	Taupe.prototype.capturer = function (){
		console.log("Capturer Taupe");
		this.setState(-1);		
	}
	
	Taupe.prototype.sortir = function (){
		console.log("Sortir en position =" + this.getPosition());
		if (this.getState() != -1){
			var cell = document.getElementById(this.getPosition());
			cell.className="show";
			cell.appendChild(this.img);
			
			this.setState(1);
//			console.log("Appel rentrer method delay= " + this.timeToOut);
			setTimeout(this.rentrer.bind(this), this.timeToOut);
		}
	};
	
	Taupe.prototype.rentrer = function (){
		console.log("rentrer");
		var cell = document.getElementById(this.getPosition());
		cell.className="hide";
		cell.removeChild(cell.firstChild);
		
		this.img.src = 'resources/img/mole.png';
		
		if (!this.killer){
			this.game.decreaseLife();
		}

		this.killer = false;
		if (this.getState() != -1){
			this.setState(2);
			this.deplacer();
		}
	};
	
	Taupe.prototype.deplacer = function(){
		
		if (this.getState() != -1) {
			
			// liberer la position
			if (this.getPosition() != -1){
				this.game.exitPosition(this.getPosition());
			}
			
			// calcul position aléatoire
			var position = -1;
			do {
				position = Math.floor((Math.random() * this.gridSize) + 1);
				console.log(position);
			}
			while(this.game.takePosition(position) && position != -1);
			
			this.setPosition(position);
			console.log("deplacer au trou id=" + this.getPosition());
			
			// sortir
//			console.log("Appel sortir method delay= " + this.timeToMove);
			setTimeout(this.sortir.bind(this),this.timeToMove);
		}		
	};
	
	Taupe.prototype.taper= function(){
		console.log('Tape taupe');
		if (!this.killer){
			this.killer = true;
			this.img.src = 'resources/img/moleKill.png';
			this.game.increasePoint();
		}
	};
	
	// GameSpace
	function GameSpace(){
		this.boardGame = null;
		this.gridSize = 5;
		this.lifeCounter = null;
		this.pointCounter = null;
		this.maxPointCounter = null;
	}
	
	GameSpace.prototype.getBoardGame = function(){
		return this.boardGame;
	};
	
	GameSpace.prototype.getGridSize = function(){
		return this.gridSize;
	};
	
	GameSpace.prototype.setGridSize = function(value){
		this.gridSize = value;
	};
	
	GameSpace.prototype.setLifeCounter = function(counter){
		if (this.lifeCounter != null
				&& counter instanceof Counter){
			var div = this.lifeCounter.lastChild;
			div.textContent = counter.getValue();
		}
	};
	
	GameSpace.prototype.setPointCounter = function(counter){
		if (this.pointCounter != null
				&& counter instanceof Counter){
			var div = this.pointCounter.lastChild;
			div.textContent = counter.getValue();
		}
	};
	
	GameSpace.prototype.setMaxPointCounter = function(counter){
		if (this.maxPointCounter != null
				&& counter instanceof Counter){
			var div = this.maxPointCounter.lastChild;
			div.textContent = counter.getValue();
		}
	};
	
	GameSpace.prototype.init = function (){		
		
//		console.log("Make the board game");
		
		// Board game
		var container = document.getElementById('gameSpace');		
		this.boardGame = document.createElement('div');
		this.boardGame.id = "boardGame";
		container.appendChild(this.boardGame);
		
		if (this.boardGame.children.length > 0){
			this.boardGame.removeChild(this.boardGame.firstChild);
		}
		
		// Grid				
		var grid = document.createElement('table');
		for (var i = 0; i < this.getGridSize(); i++) {
			var row = grid.insertRow();
			for (var j = 0; j < this.getGridSize(); j++) {
				var cell = row.insertCell();
				cell.id= (i*this.getGridSize()) + j + 1;
				cell.className="hide";
			}
		}
		var div = document.createElement('div');
		div.className = "grid";
		div.appendChild(grid);
		this.boardGame.appendChild(div);
		
		// Counter Life
		var container = document.getElementById('gameCounters');
		
		// Life
		this.lifeCounter = document.createElement('div');
		this.lifeCounter.id = "lifeCounter";
		this.lifeCounter.className = "counter";
		
		var lbl = document.createElement('div');
		lbl.className = "counterLabel";
		lbl.textContent = "Life";
		this.lifeCounter.appendChild(lbl);
		
		var div = document.createElement('div');
		div.className = "counterValue";
		this.lifeCounter.appendChild(div);
		
		container.appendChild(this.lifeCounter);
		
		// Score
		this.pointCounter = document.createElement('div');
		this.pointCounter.id = "pointCounter";
		this.pointCounter.className = "counter";
		
		lbl = document.createElement('div');
		lbl.className = "counterLabel";
		lbl.textContent = "Score";
		this.pointCounter.appendChild(lbl);
		
		div = document.createElement('div');
		div.className = "counterValue";
		this.pointCounter.appendChild(div);
		
		container.appendChild(this.pointCounter);
		
		// Score Max
		this.maxPointCounter = document.createElement('div');
		this.maxPointCounter.id = "maxPointCounter";
		this.maxPointCounter.className = "counter";
		
		document.createElement('div');
		lbl = document.createElement('div');
		lbl.className = "counterLabel";
		lbl.textContent = "Score Max";
		this.maxPointCounter.appendChild(lbl);
		
		div = document.createElement('div');
		div.className = "counterValue";
		this.maxPointCounter.appendChild(div);
		
		container.appendChild(this.maxPointCounter);
	}
	
	// Game
	function Game() {
		this.gameSpace = null;
		this.lifeCounter = null;
		this.pointCounter = null;
		this.maxPointCounter = null;		
		this.taupeList = [];
		this.positionList = [];
	}
	
	Game.prototype.setLifeCounter = function(value){
		
		if (this.lifeCounter == null){
			this.lifeCounter = new Counter();
		}		
		this.lifeCounter.setValue(value);
		this.gameSpace.setLifeCounter(this.lifeCounter);
		
	};
	
	Game.prototype.setPointCounter = function(value){
		if (this.pointCounter == null){
			this.pointCounter = new Counter();
		}
		this.pointCounter.setValue(value);
		this.gameSpace.setPointCounter(this.pointCounter);
	};
	
	Game.prototype.setMaxPointCounter = function(value){
		if (this.maxPointCounter == null){
			this.maxPointCounter = new Counter();
			this.maxPointCounter.setValue(value);
		}
		else if (value > this.maxPointCounter.getValue()){
			this.maxPointCounter.setValue(value);
		}		
		this.gameSpace.setMaxPointCounter(this.maxPointCounter);
	};
	
	Game.prototype.load = function (){		
		console.log("Load game ...");
		this.gameSpace = new GameSpace();		
		this.gameSpace.init();
	}
	
	Game.prototype.reset = function (){
		console.log("Reset ...");
		// reinit des compteurs
		this.setLifeCounter(3);
		this.setPointCounter(0);
		this.setMaxPointCounter(0);
		
		// suppression des taupes
		console.log(this.taupeList);
		while(this.taupeList.length > 0){			
			this.taupeList.pop();
		}
		console.log(this.taupeList);
	}
	
	Game.prototype.start = function (){		
		console.log("Start game ...");		
		
		this.reset();
		// lacher d'une taupe		
		this.lacherUneTaupe();
	}

	Game.prototype.stop = function (){
		console.log("Stop game ...");
		this.setMaxPointCounter(this.pointCounter.getValue());
		var list = this.taupeList;
		for (var i = 0; i < list.length; i++) {
			this.taupeList[i].capturer();
		}
		alert('Game Over');
	}
	
	Game.prototype.lacherUneTaupe = function (){
		console.log("Lacher de taupe");
		var taupe = new Taupe();
		taupe.init();
		var index = this.taupeList.push(taupe);
		console.log(this.taupeList);
		taupe.id = index;
		var nbPositions = this.gameSpace.getGridSize() * this.gameSpace.getGridSize();
		taupe.gridSize = nbPositions;
		taupe.game = this;
		taupe.liberer();
	}
	
	Game.prototype.isGameOver = function (){
		console.log("Test if Game Over");
		if (this.lifeCounter.getValue() <= 0){			 
			return true;
		}
		return false;
	}
	
	Game.prototype.exitPosition = function (position) {
		console.log("exitPosition : " + position);
		console.log(this.positionList);
		var positionList = this.positionList;
		for (var i = 0; i < positionList.length; i++) {
			if (positionList[i] == position){
				positionList.splice(i,1);
				console.log("position liberer : " + position);
				console.log(this.positionList);
				break;
			}
		}
	}
	
	Game.prototype.takePosition = function (position) {
		console.log("takePosition : " + position);
		console.log(this.positionList);
		
		var taken = false;
		var positionList = this.positionList;
		for (var i = 0; i < positionList.length; i++) {
			if (positionList[i] == position){
				console.log("position prise : " + position);
				taken = true;
				break;
			}
		}
		if (!taken){
			this.positionList.push(position);
		}
		return taken;
	}
	
	Game.prototype.decreaseLife = function (){
//		console.log("Decrease Life");
		this.lifeCounter.decrease(1);
		this.gameSpace.setLifeCounter(this.lifeCounter);

		if ( this.isGameOver()) {
			this.stop();
		}
	}
	
	Game.prototype.increasePoint = function (){
//		console.log("Increase Point");
		this.pointCounter.increase(100);
		this.gameSpace.setPointCounter(this.pointCounter);
		
		var nbTaupe = this.taupeList.length;
		if (this.pointCounter.getValue() >= (nbTaupe*1000)){	
			this.lacherUneTaupe();
		}
	}
	
	var game = null;
	
	function loadGame(){
		game = new Game();
		game.load();
	}
	
	function startGame() {
		game.start();
	}
	
	function stopGame() {
		game.stop();	
	}
