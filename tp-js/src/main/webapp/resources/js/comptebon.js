
	var tabvalue = new Array(24);
	var tirage = new Array(6);
	var startCounter = false;

	function launchGame(){		
		load_game();
		newGame();				
	}
	
	function newGame() {
		stopGame();		
		load_newmission();
		displayMission();
	}
	
	function startGame() {
		startCounter = true;
		refreshTimeLeft();		
	}
	
	function stopGame() {
		startCounter = false;
		document.getElementById('countervalue').innerHTML='0';
		for(var i=0;i<60;i++){
			var cell = document.getElementById('cellcounter' + i);
			cell.className = 'green';
		}		
	}
	
	function exitGame(){
		stopGame();
	}

	function refreshTimeLeft() {
		var counter = document.getElementById('countervalue');
		var countervalue = parseInt(counter.innerHTML);		
		var cell = document.getElementById('cellcounter' + countervalue);		
		if (countervalue >= 60) {
			alert('Le temps est dépassé');
		}
		else {
			countervalue++;
			document.getElementById('countervalue').innerHTML = countervalue;			
			cell.className = 'red';
			if (startCounter) {
				setTimeout("refreshTimeLeft()",1000);
			}
		}		
	}

	function load_game() {
		//Création de tableau général
		for(var nbr=0;nbr<=24;nbr++){
			//définition des tableaux internes
			tabvalue[nbr]=new Array();
			//chargement de la ligne 0 avec la valeur 0
			tabvalue[nbr][0]=0;
		}
		
		//Chargement dans tabvalue des 24 chiffres pour le tirage dans la 2eme ligne
		//Chargement des nombres 1 à 10 : 2 fois
		for(nbr=1;nbr<=10;nbr++){
			tabvalue[nbr][1]=nbr;
			tabvalue[nbr+10][1]=nbr;
		}
		//Chargement des nombres 25, 50, 75, 100
		tabvalue[21][1]=25;
		tabvalue[22][1]=50;
		tabvalue[23][1]=75;
		tabvalue[24][1]=100;
	}

	function load_newmission() {
		counter=1;
		validnbr=0;
		//Réinitialisation de la 1eme ligne de tabvalue
		for(nbr=0;nbr<=24;nbr++) {
			tabvalue[nbr][0]=0;
		}
		
		//Calcul du nombre à trouver entre 1 et 999
		tabvalue[0][0]=Math.round((Math.random()*998)+1);
		tirage[0]=tabvalue[0][0];
		
		/*choix de 6 valeurs dans le tableau tabvalue de facon aléatoire
		et on applique un 1 dans la ligne 0 */
		do {
			nbrrandom=Math.round((Math.random()*23)+1);
			validnbr=tabvalue[nbrrandom][0];
			if (!validnbr) {
				tabvalue[nbrrandom][0]=1;
				tirage[counter]= tabvalue[nbrrandom][1];
				counter++;
			}
		}while (counter<=6)				
	}

	function displayMission() {
		for ( var i = 0; i < 7; i++) {
			var td = document.getElementById('chiffre' + i).innerHTML = tirage[i];
		}
	}
