window.onload = function () {
	
	var keys = Object.keys(analise);
	var contentSequencias = document.getElementById("content-sequencias");

	for (i = 0; i < keys.length; i++) {
		
		var divSequencia = document.createElement("div");
		divSequencia.className = "flexWrap";
		
		var split = keys[i].split(";");
		
		for (j = 0; j < split.length; j++) {
			
			var divSeqDezena = document.createElement("div");
		
			divSeqDezena.className = "dezena";
		
			divSeqDezena.innerText = split[j];
			
			divSequencia.appendChild(divSeqDezena);
		}
		
		var divQtVezes =  document.createElement("div");
		divQtVezes.style.marginLeft = '10px';
		divQtVezes.innerText = ' Sequencia com '+ split.length +' dezenas seguidas e saiu '+ analise[keys[i]] + ' vezes.';
		
		divSequencia.appendChild(divQtVezes);
		
		contentSequencias.appendChild(divSequencia);
	}
}