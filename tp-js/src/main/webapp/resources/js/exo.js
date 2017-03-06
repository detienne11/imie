
function afficheResultat(id,msg){
	var elt = document.getElementById(id);
	elt.innerHTML = msg;
	console.log(msg);
}

function calculSante(id){
		var inputAge = document.getElementById(id);
		var age = inputAge.value;
		
		var msg = "...";
		if (age >= 100){
			msg = "En bonne santé.";
		}
		else if (age >= 50 && age < 100) {
			msg = "Blessé...";
		}
		else if (age > 0 && age <50) {
			msg = "En danger";
		}
		else {
			msg = "KO";
		}
	
		afficheResultat('sante',msg);
		
}

function calculPrix(id){
	var nb = document.getElementById(id).value;
	var montant = 0;
	
	if (nb > 30) {
		montant += 0.05 * (nb - 30) ;
		montant += 0.08 * 20 ;
		montant += 0.1 * 10 ;
	}
	else if (nb > 10) {
		montant += 0.08 * (nb - 10) ;
		montant += 0.1 * 20 ;
	}
	else if (nb > 0 ) {
		montant += 0.1 * nb;
	}	
	afficheResultat('montant',montant);

}

function calcul(value){
	var factoriel = 1; 
	if (value > 1){
		factoriel = value * calcul(value-1);
	}
	return factoriel;
}

function calculFactoriel(id){
	var value = document.getElementById(id).value;
	var factoriel = calcul(value);
	afficheResultat('factoriel',factoriel);
}

function afficherTableau(tab){
	document.write("Valeurs dans un tableau : ");
	for(var i=0;i< tab.length;i++){
		document.write(tab[i] + " - ");
	}
	document.write("<br/>");
}

function trierTab(tab){
		
	for(var i=0; i < tab.length; i++){
		var tmp = tab[i];
		if ((i+1) < tab.length){
			if (tab[i] > tab[i+1]){
				tab[i] = tab[i+1];
				tab[i+1] = tmp;
				i=-1;
			}
		}	
	}
	return tab;
}

function trierTab2(tab,fct){
	
	for(var i=0; i < tab.length; i++){
		fct(tab);
		console.log("Valeur de i:" + i)
		var tmp = tab[i];
		if ((i+1) < tab.length){
			if (tab[i] > tab[i+1]){
				tab[i] = tab[i+1];
				tab[i+1] = tmp;
				i=-1;
			}
		}	
	}
	return tab;
}

function trierTab7bis(tab,fct){
	
	for(var i=0; i < tab.length; i++){		
		console.log("Valeur de i:" + i)
		var tmp = tab[i];
		if ((i+1) < tab.length){
			if (fct(tab[i],tab[i+1])){
				tab[i] = tab[i+1];
				tab[i+1] = tmp;
				i=-1;
			}
		}	
	}
	return tab;
}

function afficherObjectTableau(tab,fct){
	document.write("Valeurs dans un tableau :<br/>");
	for(var i=0;i< tab.length;i++){
		fct(tab[i]);
	}
	document.write("<br/>");
}