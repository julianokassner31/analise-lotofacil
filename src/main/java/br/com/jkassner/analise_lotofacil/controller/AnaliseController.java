package br.com.jkassner.analise_lotofacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.jkassner.analise_lotofacil.response.AnaliseResponse;
import br.com.jkassner.analise_lotofacil.service.AnaliseService;

@Controller
public class AnaliseController {

	@Autowired
	AnaliseService analiseService;
	
	@GetMapping(value = "/form")
	public String form (Model model) {
		return "form"; 
	}
	
	@PostMapping(value = "/analise")
	public String teste(int qtJogos, Model model) {
		
		AnaliseResponse analise = analiseService.analisar(qtJogos);
		
		model.addAttribute("qtJogos", qtJogos);
		model.addAttribute("analise", analise);
		
		return "analise";
	}
}
