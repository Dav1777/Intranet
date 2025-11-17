package com.saf.intranet.repositories;

import com.saf.intranet.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<ChamadoRepository, Long> {

    List<Chamado> FindByChamadoId(Long chamadoId);
}
