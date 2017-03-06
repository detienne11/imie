
function startGame() {
	launchGame();
}

function launchGame() {
	var gameBox = load_game();
	newGame(gameBox);
}

function newGame(gameBox) {
	load_newmission(gameBox);
}

function EventHandler(e) {
	e = e || window.event;
	var target = e.target || e.srcElement;
	if (e.type == 'click'){	
		selectCard(target);
	}
}

function selectCard(elt) {	
	if (elt != null){
		
		// etat du plateau du jeu
		var imgs = board.getElementsByTagName('img');
		console.log(imgs.length);
		
		// calcul du nombre de img en show
		var count = 0;
		var selectImg = new Array(2);
		for (var i=0; i < imgs.length; i++){
			if (imgs[i].parentNode.className != "good"
					&& imgs[i].className == "show"){
				selectImg[count]= imgs[i];
				count++;
			}
		}
		console.log("Nombre de card:" + count);
		
		if (count > 1){
			// remise à hide des img
			for (var i=0; i < imgs.length; i++){
				if (imgs[i].parentNode.className != "good"){
					imgs[i].className = "hide";
				}
			}
		}

//		else {
			var figure = elt.parentNode;		
			if (figure.className != "good") {
				var style = elt.className;
				if (style == "hide"){
					elt.className="show";
					if (count == 1){
						console.log("index1: " + selectImg[0].getAttribute('index'));
						console.log("index2: " + elt.getAttribute('index'));
						if (selectImg[0].getAttribute('index') == elt.getAttribute('index')){
							figure.className = "good";
							selectImg[0].parentNode.className = "good";
						}
					}
//					elt.setAttribute('select',true);
				}
//				else {
//					elt.className="hide";
////					elt.setAttribute('select',false);
//				}
//			}
		}
		
	}
}

function load_game() {
	
	var gameBox = document.createElement('div');
	
	var imgs = [
		'resources/img/6995-l_square.jpg',
		'resources/img/avatar_8f1ac442d592_128.png',
		'resources/img/s1vh7z1n.jpg',
		'resources/img/avatar_17135998b3f5_128.png',
		'resources/img/avatar_52e80e3ad564_128.png',
		'resources/img/avatar_1d84667d2b3a_128.png',
		'resources/img/avatar_77caa9553877_128.png',
		'resources/img/a54b5695412c7e55d449f1146cd2a6ab128.png' ];
	
	// creation du couple d'images 
	for (var i = 0; i < imgs.length; i++) {
		for (var j = 0; j < 2; j++) {
			var index = i*2 + j;
			var img = document.createElement("img");
			img.id= index;
			img.className="hide";
			img.src=imgs[i];
			img.setAttribute("index",i);
			img.addEventListener("click", EventHandler);
			gameBox.appendChild(img);
		}
	}
	
	return gameBox;
}

function load_newmission(gameBox) {
	
	var cards = gameBox.children;
	var nbCards = cards.length;
	
	// Chargement des couples d'images
	var board = document.getElementById('board');
	
	// RAZ des img
	while (board.hasChildNodes()) {   
		board.removeChild(board.firstChild);
	}
	
	// nb
	for (var i = 0; i < nbCards; i++) {
		var figure = document.createElement("figure");
		figure.id=i;
//		figure.className="good";

		// choix d'une carte aléatoire
		var nb = gameBox.children.length;
		console.log("Nb carte restantes=" + gameBox.children.length);
		var rnd = Math.floor((Math.random() * nb));
		console.log("Id Random Card=" + rnd);
		var card  = cards[rnd];
		gameBox.removeChild(card);

		figure.appendChild(card);
		board.appendChild(figure);		
	}
	
}