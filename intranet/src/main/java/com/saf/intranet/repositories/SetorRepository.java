package com.saf.intranet.repositories;

import com.saf.intranet.models.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    List<Setor> findByNomeContainingIgnoreCase(String nome);
}
