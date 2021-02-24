package br.com.jkassner.analise_lotofacil.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConcursoLotoFacilDto {

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataApuracao;
	private List<Integer> dezenasSorteadasOrdemSorteio = new ArrayList<>();
	private List<Integer> listaDezenas = new ArrayList<>();
	private Long numero;
	private List<RateioDto> listaRateioPremio = new ArrayList<>();
	private BigDecimal valorAcumuladoConcursoEspecial;
	private BigDecimal valorArrecadado;
	private List<CidadeDto> listaMunicipioUFGanhadores = new ArrayList<>();
	private BigDecimal valorAcumuladoProximoConcurso;
}
