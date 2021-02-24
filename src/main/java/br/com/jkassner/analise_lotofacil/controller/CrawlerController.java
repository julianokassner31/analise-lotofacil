package br.com.jkassner.analise_lotofacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkassner.analise_lotofacil.dto.ConcursoLotoFacilDto;
import br.com.jkassner.analise_lotofacil.service.CrawlerService;

@RestController
@RequestMapping("/crawlerJogos")
@CrossOrigin(allowedHeaders = "*")
public class CrawlerController {

	@Autowired
	private CrawlerService crawlerService;
	
	@PostMapping("/lotofacil")
	public ResponseEntity<?> crawler(@RequestBody ConcursoLotoFacilDto concursoDto) {
		
		crawlerService.saveConcursoLotoFacil(concursoDto);
		
		return ResponseEntity.ok("Jogo salvo com sucesso");
	}
}
