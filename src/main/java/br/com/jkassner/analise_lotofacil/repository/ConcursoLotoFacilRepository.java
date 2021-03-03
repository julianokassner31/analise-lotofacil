package br.com.jkassner.analise_lotofacil.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jkassner.pojo.model.ConcursoLotoFacil;

@Repository
public interface ConcursoLotoFacilRepository extends JpaRepository<ConcursoLotoFacil, Long>{

	@Query("select c from ConcursoLotoFacil c")
	public List<ConcursoLotoFacil> getUltimosConcursos(Pageable pageable);
}
