/*****************************************************/

function login() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	if((username != null || username != "") && (password != null || password != "")) {
		if(username == password) {
			storeQuantScore(0);
			storeVerbalScore(0);
			storeVideoScore(0);
			setQuestionCount();
			window.location.href = "math_question.html";
		} else {
			alert("Sorry wrong username/password");
		}
	}
}

/*******************************************************/

function checkAnswer1() {
	var correctAnswer = document.getElementsByName('correct-answer').value;
	var answer;
	var radios = document.getElementsByName('answer');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer = radios[i].value;
			break;
		}
	}
	if(answer != null && answer != "" && answer == "a") {
		var quant_score = parseInt(localStorage.getItem("quant_score")) + 1;
		storeQuantScore(quant_score);
	}
	incrQuantCount();
	window.location.href = "trig_question.html";
}

function checkAnswer2() {
	var correctAnswer = document.getElementsByName('correct-answer').value;
	var answer;
	var radios = document.getElementsByName('answer');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer = radios[i].value;
			break;
		}
	}

	if(answer != null && answer != "" && answer == "a") {
		var quant_score = parseInt(localStorage.getItem("quant_score")) + 1;
		storeQuantScore(quant_score);
	}
	incrQuantCount();
	window.location.href = "english_question.html";
}


function checkAnswer3() {
	var correctAnswer1 = document.getElementsByName('correct-answer1').value;
	var correctAnswer2 = document.getElementsByName('correct-answer2').value;
	var answer1;
	var answer2;
	var radios = document.getElementsByName('blank1');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer1 = radios[i].value;
			break;
		}
	}
	
	var radios = document.getElementsByName('blank2');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer2 = radios[i].value;
			break;
		}
	}

	if((answer1 != null && answer1 != "" && answer1 == "$650") && (answer2 != null && answer2 != "" && answer2 == "Twitter")) {
		var verbal_score = parseInt(localStorage.getItem("verbal_score")) + 1;
		storeVerbalScore(verbal_score);
	}
	incrVerbalCount();
	window.location.href = "video_question.html";
}


function checkAnswer4() {
	var correctAnswer = document.getElementsByName('correct-answer').value;
	var answer;
	var radios = document.getElementsByName('answer');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer = radios[i].value;
			break;
		}
	}

	if(answer != null && answer != "" && answer == "a") {
		var video_score = parseInt(localStorage.getItem("video_score")) + 1;
		storeVideoScore(video_score);
	}
	incrVideoCount();	
	window.location.href = "survey.html";
}

/*******************************************************/

function fillBlank1() {
	var answer;
	var radios = document.getElementsByName('blank1');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer = radios[i].value;
			break;
		}
	}
	document.getElementById("fill1").innerHTML = ""+answer;
}


function fillBlank2() {
	var answer;
	var radios = document.getElementsByName('blank2');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer = radios[i].value;
			break;
		}
	}
	document.getElementById("fill2").innerHTML = ""+answer;
}

/***************************************************/

function scoreFunction() {
	var quant_score = localStorage.getItem("quant_score");
	var verbal_score = localStorage.getItem("verbal_score");
	var video_score = localStorage.getItem("video_score");
	
	var quant_count = localStorage.getItem("quant_count");
	var verbal_count = localStorage.getItem("verbal_count");
	var video_count = localStorage.getItem("video_count");
	
	document.getElementById("quant_count").innerHTML = ""+quant_count;
	document.getElementById("verbal_count").innerHTML = ""+verbal_count;
	document.getElementById("video_count").innerHTML = ""+video_count;
	
	document.getElementById("quant_correct").innerHTML = ""+quant_score;
	document.getElementById("verbal_correct").innerHTML = ""+verbal_score;
	document.getElementById("video_correct").innerHTML = ""+video_score;
	
	document.getElementById("quant_score").innerHTML = ""+(quant_score * 50);
	document.getElementById("verbal_score").innerHTML = ""+(verbal_score * 50);
	document.getElementById("video_score").innerHTML = ""+(video_score * 50);
}


function getScore() {
	window.location.href = 'summary.html';
}


function storeQuantScore(value) {
	if (typeof(Storage) !== "undefined") {
		localStorage.setItem("quant_score", value);
	} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	}
}

function storeVerbalScore(value) {
	if (typeof(Storage) !== "undefined") {
		localStorage.setItem("verbal_score", value);
	} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	}
}

function storeVideoScore(value) {
	if (typeof(Storage) !== "undefined") {
		localStorage.setItem("video_score", value);
	} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	}
}


/**********************************************************************************/

function setQuestionCount() {
	if (typeof(Storage) !== "undefined") {
		localStorage.setItem("quant_count", 0);
		localStorage.setItem("verbal_count", 0);
		localStorage.setItem("video_count", 0);
	} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	}
}

function incrQuantCount() {
	if (typeof(Storage) !== "undefined") {
		var cnt = parseInt(localStorage.getItem("quant_count")) + 1;
		localStorage.setItem("quant_count", cnt);
	} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	}
}

function incrVerbalCount() {
	if (typeof(Storage) !== "undefined") {
		var cnt = parseInt(localStorage.getItem("verbal_count")) + 1;
		localStorage.setItem("verbal_count", cnt);
	} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	}
}

function incrVideoCount() {
	if (typeof(Storage) !== "undefined") {
		var cnt = parseInt(localStorage.getItem("video_count")) + 1;
		localStorage.setItem("video_count", cnt);
	} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	}
}

/******************************************************/

function finish() {
	window.location.href = 'index.html';
}
