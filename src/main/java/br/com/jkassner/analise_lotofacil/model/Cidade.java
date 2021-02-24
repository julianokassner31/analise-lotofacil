package br.com.jkassner.analise_lotofacil.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cidade")
@Getter
@Setter
public class Cidade implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nm_cidade")
    private String nmCIdade;

    @Column(name = "uf")
    private String uf;

    @ManyToOne
    @JoinColumn(name = "id_concurso_lotofacil", referencedColumnName = "id_concurso")
    @JsonIgnore
    private ConcursoLotoFacil concursoLotoFacil;

}
