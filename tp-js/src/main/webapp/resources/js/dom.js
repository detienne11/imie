function changeUrl(){
	
//	var linkList = document.getElementsByTagName("a");
	var linkList = document.links;
	var msg = "";
	for (var i = 0; i < linkList.length; i++) {
		msg += linkList[i].textContent;
		msg += " - url=";
		msg += linkList[i].href;
		msg += "<br/>";
		linkList[i].textContent = "IMIE";
		linkList[i].href="http://www.imie-ecole-informatique.fr";
	}
	
	console.log(msg);	
}

function createMenu(id){
	var eltD = document.getElementById(id);
	
	var eltP = document.createElement("p");
	// cas 1
//	var textP = document.createTextNode("Liste des cours :");
//	eltP.appendChild(textP);
	// cas 2
//	eltP.innerHTML = "Liste des cours :";
	// cas 3 
//	eltP.innerText = "Liste des cours :";
	// cas 4 : a privilegier
	eltP.textContent = "Liste des cours :";
	
	var eltUL = document.createElement("ul");
	eltUL.className = "li-menu";
	eltUL.id = "menu";
	
	var eltLI = document.createElement("li");
	eltLI.textContent = "JavaScript";
	eltUL.appendChild(eltLI);
	
	var eltLI = document.createElement("li");
	eltLI.textContent = "Symfony";
	eltUL.appendChild(eltLI);
	
	var eltLI = document.createElement("li");
	eltLI.textContent = "Magento";
	eltUL.appendChild(eltLI);
	
	var eltLI = document.createElement("li");
	eltLI.textContent = "Phonegap";
	eltUL.appendChild(eltLI);
	
	eltD.appendChild(eltP);
	eltD.appendChild(eltUL);
	
}

function invert(id){
	
	var div = document.getElementById(id);
	var childList = div.children;
	var elt = null;
	for (var i = 0; i < childList.length; i++) {
		if (childList[i] != null
				&& childList[i].id == "menu"){
			elt = childList[i];
			break;
		}
	}
		
	var nodes = elt.children;
	for (var i = (nodes.length-2); i >= 0; i--) {		
		var node = nodes[i];
		elt.appendChild(node);
	}
}

/* Exercice 4: 
 * 
 * Écrivez une fonction qui prend en paramètre l'identifiant d'un élément du DOM et un tableau
d'objets (de même classe).
Cette fonction devra créer un tableau HTML dans l'élément passé en paramètre.
Les colonnes
devront correspondre aux attributs, et les lignes aux objets.
*/
function createTable(id,table){
	var div = document.getElementById(id);
	
	var tab = document.createElement("table");
	div.appendChild(tab);
	
	for (var i = 0; i < table.length; i++) {
						
		var row = tab.insertRow();
		var cell = row.insertCell();
		cell.textContent=i;
		var obj = table[i];

//		var fields = Object.keys(obj);
//		for (var j = 0; j < fields.length; j++) {
//			var cell1 = row.insertCell();
//			cell1.textContent=obj[fields[j]];
//		}
		
		for (var prop in obj){
			var cell1 = row.insertCell();
			cell1.textContent=obj[prop];
		}
	}
	
}
