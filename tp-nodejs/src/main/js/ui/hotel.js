
module.exports = {htmlRender,htmlRender3, avgByCity, capacityByCity};

function avgByCity(avg) {
	var html = "<html>\n";
	html += "\t<body>\n";	
	html += "\t\t<header>\n";
	html += "\t\t<h1>TP Node JS</h1>\n";
	html += "\t\t</header>\n";
	html += "\t\t<main>\n";
	html += "\t\t\t<nav>\n";
	html += "\t\t\t<ul>\n";
	html += "\t\t\t<li><a href=\"/hotels\">Hotels</a></li>\n";
	html += "\t\t\t</ul>\n";
	html += "\t\t\t</nav>\n";
	html += "<p>Moyenne : ";
	html += avg;
	html += " étoiles</p>";
	html += "\t\t</main>\n";		
	html += "\t</body>\n";
	html += "</html>";
	return html;
}

function capacityByCity(capacity) {
	var html = "<html>\n";
	html += "\t<body>\n";	
	html += "\t\t<header>\n";
	html += "\t\t<h1>TP Node JS</h1>\n";
	html += "\t\t</header>\n";
	html += "\t\t<main>\n";
	html += "\t\t\t<nav>\n";
	html += "\t\t\t<ul>\n";
	html += "\t\t\t<li><a href=\"/hotels\">Hotels</a></li>\n";
	html += "\t\t\t</ul>\n";
	html += "\t\t\t</nav>\n";
	html += "<p>Capacity : ";
	html += capacity;
	html += "</p>";
	html += "\t\t</main>\n";		
	html += "\t</body>\n";
	html += "</html>";
	return html;
}

function htmlRender(datas,exo){
	var html = "<html>\n";
	html += "\t<body>\n";	
	html += "\t\t<header>\n";
	html += "\t\t<h1>TP Node JS</h1>\n";
	html += "\t\t</header>\n";
	html += "\t\t<main>\n";
	html += "\t\t\t<nav>\n";
	html += "\t\t\t<ul>\n";
	html += "\t\t\t<li><a href=\"/hotels\">Hotels</a></li>\n";
	html += "\t\t\t</ul>\n";
	html += "\t\t\t</nav>\n";
	
	html += htmlSectionSearch();
	if (exo == 'exo1') {
		html += htmlSectionResult1(datas);
	}
	else if (exo == 'exo2') {
		html += htmlSectionResult2(datas);
	}
	else if (exo == 'exo3') {
//		html += htmlSectionResult3(datas);
	}
	else {
		html += "Pas de contenu";
	}
	html += "\t\t</main>\n";		
	html += "\t</body>\n";
	html += "</html>";
	return html;
}


function htmlRender3(datas,avg,capacity){
	var html = "<html>\n";
	html += "\t<body>\n";	
	html += "\t\t<header>\n";
	html += "\t\t<h1>TP Node JS</h1>\n";
	html += "\t\t</header>\n";
	html += "\t\t<main>\n";
	html += "\t\t\t<nav>\n";
	html += "\t\t\t<ul>\n";
	html += "\t\t\t<li><a href=\"/hotels\">Hotels</a></li>\n";
	html += "\t\t\t</ul>\n";
	html += "\t\t\t</nav>\n";	
	html += htmlSectionSearch();
	html += htmlSectionResult3(datas,avg,capacity);
	html += "\t\t</main>\n";		
	html += "\t</body>\n";
	html += "</html>";
	return html;
}

function htmlSectionSearch(){
	var html = "<section>\n";
	html += "\t<form action=\"/ville\" method=\"get\">\n";
	html += "\t\t<label>Code Postal :</label><input type=\"text\" name=\"codePostal\" placeHolder=\"Entrez un code Postal\">";
	html += "\t\t<input type=\"submit\" value=\"Valider\" >";	
	html += "\t</form>\n";
	html += "</section>\n";
	return html;	
}

function htmlSectionResult1(datas){
	var html ="<section>\n<table>\n";
	
	// column header
	for (var data of datas) {
		html += "<tr>";
		html += "<th>id</th>";
		for (var field in data) {
			html += "<th>";
			html += field;
			html += "</th>";
		}
		html += "</tr>\n";
		break;
	}
	
	// row  
	for (var data of datas) {
		html += "<tr>";
		html += "<td><a href=\"/hotel?id=" + data.id + "\">";
		html += "id";
		html += "</a></td>";
		for (var field in data) {
			html += "<td>";
			if (field == 'codepostal'){
				html += "<a href=\"/ville?codePostal=" + data[field] + "\">";
				html += data[field];
				html += "</a>";
			}
			else {				
				html += data[field];
			}			
			html += "</td>";
		}
		html += "</tr>\n";
	}
	
	html += "</table>\n<section>\n";
	return html;
}

function htmlSectionResult2(datas){
	var html ="<section>\n<table>\n";
//	console.log(datas);

	for (var field in datas.fields) {
		html += "<tr>";	
		html += "<th>";
		html += field;
		html += "</th>";
		html += "<td>";
		html += datas.fields[field];
		html += "</td>";
		html += "</tr>\n";
	}
	
	html += "</table>\n<section>\n";
	return html;
}

function htmlSectionResult3(datas,avg,capacity){
	
	console.log(datas);
	
	var html ="<section>\n";
	
	html +="<p>Moyenne de la ville : " + avg + " étoiles</p>\n";
	
	html +="<p>Capacité totale de la ville : " + capacity + " personnes</p>\n";
	
	html +="<table>\n";
	
	// column header
	for (var data of datas) {
		for (var field in data.fields) {
			html += "<tr>";	
			html += "<th>";
			html += field;
			html += "</th>";
			html += "<td>";
			html += data.fields[field];
			html += "</td>";
			html += "</tr>\n";
		}
	}
	
	html += "</table>\n</section>\n";
	return html;
}

