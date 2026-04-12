package com.saf.intranet.controller;

import com.saf.intranet.dtos.FuncionarioResponseDTO;
import com.saf.intranet.dtos.LoginRequestDTO;
import com.saf.intranet.infra.CookieService;
import com.saf.intranet.repositories.FuncionarioRepository;
import com.saf.intranet.services.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;
    private final CookieService cookieService;

    public LoginController(CookieService cookieService, LoginService loginService) {
        this.cookieService = cookieService;
        this.loginService = loginService;
    }


    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> login(@RequestBody LoginRequestDTO dto, HttpServletResponse response){
        FuncionarioResponseDTO funcionario = loginService.logar(dto);

        cookieService.setCookie(response, "usuario_logado", funcionario.email(), 60 * 60);

        return ResponseEntity.ok(funcionario);
    }
}
