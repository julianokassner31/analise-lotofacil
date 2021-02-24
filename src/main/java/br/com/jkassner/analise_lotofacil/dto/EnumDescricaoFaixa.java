package br.com.jkassner.analise_lotofacil.dto;

import lombok.Getter;

@Getter
public enum EnumDescricaoFaixa {

	ACERTOS_15("15 acertos"),
	ACERTOS_14("14 acertos"),
	ACERTOS_13("13 acertos"),
	ACERTOS_12("12 acertos"),
	ACERTOS_11("11 acertos");
	
	private String descricao;
	
	EnumDescricaoFaixa(String descricao) {
		this.descricao = descricao;
	}
	
	public static EnumDescricaoFaixa getByValue(String value) {
		
		for (EnumDescricaoFaixa enumDescricaoFaixa : EnumDescricaoFaixa.values()) {
			
			if (value.equals(enumDescricaoFaixa.getDescricao())) {
				return enumDescricaoFaixa;
			}
		}
		
		return null;
	}
}
