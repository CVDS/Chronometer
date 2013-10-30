var timer = 0;
var interval;
var timeElement = document.getElementById("timer");

function start(){
	timer = 0;
	timeElement.innerHTML = timer;
	cont();
}

function pause(){
	window.clearInterval(interval);
}

function cont(){
	window.clearInterval(interval);
	interval = setInterval(function(){timer++;timeElement.innerHTML = timer;},1000);
	
}