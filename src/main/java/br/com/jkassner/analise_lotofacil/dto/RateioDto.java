package br.com.jkassner.analise_lotofacil.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateioDto {
	private int faixa;
	private int numeroDeGanhadores;
	private BigDecimal valorPremio;
	private String descricaoFaixa;
}
