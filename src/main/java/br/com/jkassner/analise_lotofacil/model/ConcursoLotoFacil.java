package br.com.jkassner.analise_lotofacil.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/*
 * @created 07/11/2020 - 12:07
 * @author Juliano Kassner
 */
@Entity
@Table(name = "concurso_lotofacil")
@Getter
@Setter
public class ConcursoLotoFacil implements Serializable, Concurso {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_concurso", nullable = false)
    private Long idConcurso;

    @Column(name = "dt_sorteio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtSorteio;

    @Column(name = "pr_dezena", nullable = false)
    private Integer prDezena;

    @Column(name = "se_dezena", nullable = false)
    private Integer seDezena;

    @Column(name = "te_dezena", nullable = false)
    private Integer teDezena;

    @Column(name = "qa_dezena", nullable = false)
    private Integer qaDezena;

    @Column(name = "qi_dezena", nullable = false)
    private Integer qiDezena;

    @Column(name = "sx_dezena", nullable = false)
    private Integer sxDezena;

    @Column(name = "st_dezena", nullable = false)
    private Integer stDezena;

    @Column(name = "ot_dezena", nullable = false)
    private Integer otDezena;

    @Column(name = "no_dezena", nullable = false)
    private Integer noDezena;

    @Column(name = "dc_dezena", nullable = false)
    private Integer dcDezena;

    @Column(name = "dpr_dezena", nullable = false)
    private Integer dprDezena;

    @Column(name = "dse_dezena", nullable = false)
    private Integer dseDezena;

    @Column(name = "dte_dezena", nullable = false)
    private Integer dteDezena;

    @Column(name = "dqa_dezena", nullable = false)
    private Integer dqaDezena;

    @Column(name = "dqi_dezena", nullable = false)
    private Integer dqiDezena;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dezenas_ordenadas", referencedColumnName = "id")
    DezenasLotoFacilOrdenadas dezenasLotoFacilOrdenadas;
}
