package com.saf.intranet.repositories;

import com.saf.intranet.models.Chamado;
import com.saf.intranet.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<ChamadoRepository, Long> {

    List<Chamado> findByStatus(Status status);

    @Query("SELECT c FROM Chamado c JOIN FETCH c.setor")
    List<Chamado> findAllWithSetor();
}
