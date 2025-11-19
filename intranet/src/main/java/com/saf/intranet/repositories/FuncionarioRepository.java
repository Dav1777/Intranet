package com.saf.intranet.repositories;

import com.saf.intranet.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioRepository, Long> {

    Optional<Funcionario> findByMatricula(String matricula);
}
