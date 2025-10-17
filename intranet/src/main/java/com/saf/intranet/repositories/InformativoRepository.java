package com.saf.intranet.repositories;

import com.saf.intranet.models.Informativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformativoRepository extends JpaRepository <Informativo, Long>{

    List<Informativo> findByAtivoTrueOrderByDataPublicacaoDesc();

    List<Informativo> findByTituloContainingIgnoreCase(String titulo);

//salvar e deletar sao *HERDADOS* do: jota pê ah repository;;;;;
}