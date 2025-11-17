package com.saf.intranet.repositories;

import com.saf.intranet.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> FindByUsuarioId(String matricula);
}
