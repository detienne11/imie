

function addListEvent(e) {
	e = e || window.event;
	var target = e.target || e.srcElement;
	if (e.type == 'click'){	
		selectItem(target);
	}
}

function selectItem(elt) {
	console.log(elt);
	console.log(elt.nodeName);
	if (elt != null
			&& elt.nodeName == "LI"){
		console.log(elt);
		
		// RAZ des items actif
		var childList = elt.parentNode.children;
		for (var i=0;i < childList.length;i++) {
			var child = childList[i];
			child.removeAttribute("class"); 
//			console.log(child);
		}
		elt.className="active";
		
	}
}

function launch() {
	
	var menu = document.getElementById('menu');	
	menu.addEventListener("click", addListEvent);
	
}


// Exo 2
function addFormEvent(e) {
	e = e || window.event;
	var target = e.target || e.srcElement;
	if (e.type == 'keyup'){
		console.log(target.value);
		copier(target);		
	}
	else if (e.type == 'submit'){
		ajouter(target);
	}
}

function copier(elt) {

	var div = document.getElementById('exo2');
	
	if (div != null){
		
		var ul = null;
		if (div.children.length == 0){
			ul = document.createElement('ul');
			div.appendChild(ul);
		}
		else {
			ul = div.firstChild;
		}
		ul.addEventListener("click", addDeleteListEvent);
//		console.log(ul);
		
		var text = elt.value;
		
		var li = ul.lastElementChild;
		if (li == null) {
			li = document.createElement('li');
		}
		li.textContent = text;
		ul.appendChild(li);
	}
	
}

function ajouter(elt) {
//	console.log(elt);
	var div = document.getElementById('exo2');
	
	if (div != null){
		
		var ul = null;
		if (div.children.length == 0){
			ul = document.createElement('ul');
			div.appendChild(ul);
		}
		else {
			ul = div.firstChild;
		}
		ul.addEventListener("click", addDeleteListEvent);
//		console.log(ul);
		
		var input = elt.children[0];
		var text = input.value;
		input.value=null;
		
		var li = document.createElement('li');
		li.textContent = text;
		ul.appendChild(li);
	}
	
}

function exo2() {	
	var form = document.getElementById('formExo2');	
	form.addEventListener('keyup', addFormEvent);
	form.addEventListener('submit', addFormEvent);
}

// exo 3
function addDeleteListEvent(e) {
	e = e || window.event;
	var target = e.target || e.srcElement;
	if (e.type == 'click'){	
		deleteItem(target);
	}
}

function deleteItem(elt) {
	if (elt != null
			&& elt.nodeName == "LI"){		
		elt.parentNode.removeChild(elt);		
	}
}

//exo 4 
//window.oncontextmenu = function () {return false;}

window.addEventListener('contextmenu', function(e) {
	
	e = e || window.event;
	var target = e.target || e.srcElement;
	
	if (target.nodeName == "LI"){
		deleteItem(target);
	}
	return false;
//	e.stopPropagation();
 
}, false);

function addItem(elt) {
	var div = document.getElementById('exo4');
	
	if (div != null){
		
		var input = elt.children[0];
		var text = input.value;
		input.value=null;
		
		var ul = null;
		var label = document.createElement('label');
		var checkbox = document.createElement('input');
		checkbox.setAttribute('type','checkbox');		
		label.textContent = text;
		console.log(label.previousSibling);
		console.log(label.previousElementSibling);
		console.log(label.nextSibling);
		console.log(label.nextElementSibling);
		label.insertBefore(checkbox,label.nextSibling);
		div.appendChild(label);
	}
}


function doneItem(elt) {
	if (elt != null
			&& elt.nodeName == "LI"){		
//		elt.className = "done";
		
		var text = elt.textContent;
		elt.textContent=null;
		
		var textBarre = document.createElement("del");
		textBarre.textContent = text;
		elt.appendChild(textBarre);
	}
}

function addTodoListEvent(e){
	e = e || window.event;
	var target = e.target || e.srcElement;
	console.log(e.type);
	console.log(e.button);
	if (e.type == 'submit'){
		addItem(target);
	}
	else if (e.type == 'click'){	
		doneItem(target);
	}
	else if (e.type == 'contextmenu'){
		deleteItem(target);
	}
}

function exo4() {	
	var form = document.getElementById('formExo4');	
	form.addEventListener("submit", addTodoListEvent,true);	
}
