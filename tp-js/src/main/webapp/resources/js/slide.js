var imgs = [
		'resources/img/6995-l_square.jpg',
		'resources/img/avatar_8f1ac442d592_128.png',
		'resources/img/s1vh7z1n.jpg',
		'resources/img/avatar_17135998b3f5_128.png',
		'resources/img/avatar_52e80e3ad564_128.png',
		'resources/img/avatar_1d84667d2b3a_128.png',
		'resources/img/avatar_77caa9553877_128.png',
		'resources/img/a54b5695412c7e55d449f1146cd2a6ab128.png' ];

var index = -1;

var timer = null;

function refreshTime() {
	
	// nouvel index
	index++;	
	if (index > (imgs.length - 1)) {
		index = 0;
	}	
	console.log(index);
	
	// modification de l'image
	var div = document.getElementById('slide');
	var child = div.children;
//	console.log(child);
	
	if (child == null
			|| child.length == 0){
		var img = document.createElement('img');
		img.src=imgs[index];
		div.appendChild(img);
	}
	else {
		var img = child[0];
		img.src=imgs[index];
	}
	
}

function startSlide(){
	console.log("start");
	if (timer == null){
		
		var nb = document.getElementById('nb').value;
		if (nb == null
				|| nb == ""
				|| nb <= 10) {
			nb = 1000;
			document.getElementById('nb').value = nb;
		}
		console.log("Time :" + nb);
		timer = setInterval(refreshTime,nb);
	}		
}

function stopSlide(){
	console.log("stop");
	if (timer != null){
		clearInterval(timer);
		timer = null;
	}
}
