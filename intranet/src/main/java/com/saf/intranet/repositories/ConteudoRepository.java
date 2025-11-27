package com.saf.intranet.repositories;

import com.saf.intranet.models.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
    List<Conteudo> findByChamadoId(Long chamadoId);
}
