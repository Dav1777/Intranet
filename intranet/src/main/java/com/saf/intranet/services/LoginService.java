package com.saf.intranet.services;

import com.saf.intranet.dtos.FuncionarioResponseDTO;
import com.saf.intranet.dtos.LoginRequestDTO;
import com.saf.intranet.models.Funcionario;
import com.saf.intranet.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public FuncionarioResponseDTO logar(LoginRequestDTO dto){
        Funcionario funcionario = funcionarioRepository.findByEmail(dto.email())
                .orElseThrow(()-> new RuntimeException("E-mail ou senha inválidos."));

        boolean senhaValida = passwordEncoder.matches(dto.senha(), funcionario.getSenha());

        if (!senhaValida){
            throw new RuntimeException("E-mail ou senha inválidos.");
        }

        return new FuncionarioResponseDTO(funcionario);
    }
}
