window.onload = function () {

	console.log(analiseSequencias);

	const divContentSequencias = document.getElementById("content-sequencias"),
		sequenceKeys = getSequenceKeys();

	for (let i = 0; i < sequenceKeys.length; i++) {
		
		const divSequencia = createDivSequencias(),
			sequencie = sequenceKeys[i].split(";"),
			bgColor = getBgColorRandom(),
			fontColor = getFontColor(bgColor);

		createDivSeqDezenas(sequencie, divSequencia, bgColor, fontColor);

		const concursos = analiseSequencias[sequenceKeys[i]];

		paintDezenasExpandirConcursos(concursos, sequencie, bgColor, fontColor);

		divSequencia.appendChild(createDivQtVezes(sequencie.length, concursos.length));

		createLinksSequenceToConcurso(concursos, divSequencia);
		
		divContentSequencias.appendChild(divSequencia);
	}
};

function paintDezenasExpandirConcursos(concursos, sequencie, bgColor, fontColor) {

	for (let i= 0; i < concursos.length; i++) {

		for (let k = 0; k < sequencie.length; k++) {
			const dezenaToPaint = document.getElementById(concursos[i] +"_"+sequencie[k]);
			dezenaToPaint.style.backgroundColor = bgColor;
			dezenaToPaint.style.color = fontColor;
			dezenaToPaint.style.fontWeight = '800';
		}
	}
}

function getSequenceKeys() {
	return Object.keys(analiseSequencias).sort((a,b) => {
		const aSplit = a.split(";").length;
		const bSplit = b.split(";").length;

		return aSplit > bSplit ? -1 : aSplit < bSplit ? 1 : 0;
	});
}

function getFontColor(bgColor) {
	const nib = bgColor.split(''),
		r = parseInt(nib[1]+nib[2],16),
		g = parseInt(nib[3]+nib[4],16),
		b = parseInt(nib[5]+nib[6],16);

	return ( r * 299 + g * 587 + b * 114) / 1000 > 128 ? '#000000' : '#FFFFFF';
}

function getBgColorRandom() {
	const letters = '0123456789ABCDEF';
	let color = '#';

	for (let i = 0; i < 6; i++) {
		color += letters[Math.floor(Math.random() * 16)];
	}

	return color;
}

function createLinksSequenceToConcurso(concursos, divSequencia) {

	const divSpansConcursos = concursos.map(concurso => {
		const span = document.createElement("span");
		span.style.padding = '0px 3px';
		const link = document.createElement("a");
		link.href = "#"+concurso;
		link.innerText = concurso;

		span.appendChild(link);

		return span;
	});

	for (let i = 0; i < divSpansConcursos.length; i++) {
		divSequencia.appendChild(divSpansConcursos[i]);
	}
}

function createDivQtVezes(sizeSequencie, numeroVezesSaiu) {
	const divQtVezes =  document.createElement("div");
	divQtVezes.style.marginLeft = '10px';
	divQtVezes.innerText = ' Sequencia com '+ sizeSequencie +' dezenas seguidas e saiu ' + numeroVezesSaiu + ' vezes no(s) ' +
		' concurso(s) ';

	return divQtVezes;
}

function createDivSequencias() {
	const divSequencia = document.createElement("div");
	divSequencia.className = "flexWrap";

	return divSequencia;
}

function createDivSeqDezenas(sequencie, divSequencia, bgColor, fontColor) {

	for (let i = 0; i < sequencie.length; i++) {

		const divSeqDezena = document.createElement("div");
		divSeqDezena.className = "dezena";
		divSeqDezena.innerText = sequencie[i];
		divSeqDezena.style.backgroundColor = bgColor;
		divSeqDezena.style.color = fontColor;
		divSeqDezena.style.fontWeight = '800';

		divSequencia.appendChild(divSeqDezena);
	}
}
