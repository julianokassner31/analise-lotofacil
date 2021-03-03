window.onload = function () {
	
	var mapDezenasConcursoToPaintSequencie = buildMapDezenasConcursoToPaintSequencie();
	
	var keys = Object.keys(analiseSequencias);
	var contentSequencias = document.getElementById("content-sequencias");
	
	var keysSort = keys.sort((a,b) => {
	    var aSplit = a.split(";").length;
	    var bSplit = b.split(";").length;
	
	    return aSplit > bSplit ? -1 : aSplit < bSplit ? 1 : 0;
	});
	
	var callbackColorsRandom = function getRandomColor() {
  		var letters = '0123456789ABCDEF';
  		var color = '#';
  		for (var i = 0; i < 6; i++) {
			color += letters[Math.floor(Math.random() * 16)];
  		}
	  		
		if (color === "#FFFFFF") {
			
			return getRandomColor();
		}
	
		return color;
	}


	var mapDezenasConcursoToPaintSequencieFilter = new Map();

	for (i = 0; i < keysSort.length; i++) {
		
		var divSequencia = document.createElement("div");
		divSequencia.className = "flexWrap";
		
		var sequencie = keysSort[i].split(";");
		
		var cor = callbackColorsRandom();
		
		for (j = 0; j < sequencie.length; j++) {
			
			var divSeqDezena = document.createElement("div");
			divSeqDezena.className = "dezena";
			divSeqDezena.innerText = sequencie[j];
			divSeqDezena.style.backgroundColor = cor;
			divSeqDezena.style.fontWeight = 800;
			
			divSequencia.appendChild(divSeqDezena);
		}
		
		mapDezenasConcursoToPaintSequencie.forEach((dezenas, jogo) => {

			var result = _.intersectionBy(dezenas, sequencie).sort((a, b) => a < b ? -1 : a > b ? 1 : 0);
			
			if (_.isEqual(result, sequencie)) {

				mapDezenasConcursoToPaintSequencieFilter.set(jogo, _.difference(dezenas, sequencie));

				for (k = 0; k < sequencie.length; k++) {
					var dezenaToPaint = document.getElementById(jogo +"_"+sequencie[k]);
					dezenaToPaint.style.backgroundColor = cor;
					dezenaToPaint.style.fontWeight = 800;
				}
			} else {
				mapDezenasConcursoToPaintSequencieFilter.set(jogo, dezenas);
			}
		});
			
		mapDezenasConcursoToPaintSequencie = mapDezenasConcursoToPaintSequencieFilter;
		
		var divQtVezes =  document.createElement("div");
		divQtVezes.style.marginLeft = '10px';
		divQtVezes.innerText = ' Sequencia com '+ sequencie.length +' dezenas seguidas e saiu '+ analiseSequencias[keysSort[i]].length + ' vezes no(s) ' +
		' concurso(s) ';
		
		var divSpansConcursos = analiseSequencias[keysSort[i]].map(tt => {
			var span = document.createElement("span");
			span.style.padding = '0px 3px';
			var link = document.createElement("a");
			link.href = "#"+tt;
			link.innerText = tt;
			
			span.appendChild(link);
			
			return span;
		});
		
		divSequencia.appendChild(divQtVezes);
		
		for (m = 0; m < divSpansConcursos.length; m++) {
			divSequencia.appendChild(divSpansConcursos[m]);
		}
		
		contentSequencias.appendChild(divSequencia);
	}
}

function buildMapDezenasConcursoToPaintSequencie() {
	var map = new Map();
	concursos.forEach(c => {
		map.set(c.idConcurso, [
			c.prDezena.toString(),
			c.seDezena.toString(),
			c.teDezena.toString(),
			c.qaDezena.toString(),
			c.qiDezena.toString(),
			c.sxDezena.toString(),
			c.stDezena.toString(),
			c.otDezena.toString(),
			c.noDezena.toString(),
			c.dcDezena.toString(),
			c.dprDezena.toString(),
			c.dseDezena.toString(),
			c.dteDezena.toString(),
			c.dqaDezena.toString(),
			c.dqiDezena.toString()
		])
	});
	
	return map;
}