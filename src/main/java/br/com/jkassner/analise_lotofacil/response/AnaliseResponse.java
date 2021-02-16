package br.com.jkassner.analise_lotofacil.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.jkassner.analise_lotofacil.model.ConcursoLotoFacil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnaliseResponse {

	List<ConcursoLotoFacil> concursos;
	Map<Integer, Integer> counterDezenas = new HashMap<>();
	Map<String, Integer> sequencias = new HashMap<>();
	
	public void setCounterDezenas(Map<Integer, List<Integer>> collect) {
		collect.entrySet().forEach(entry -> {
			this.counterDezenas.put(entry.getKey(), entry.getValue().size());
		});
	}
}
