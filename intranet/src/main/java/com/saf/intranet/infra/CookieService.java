package com.saf.intranet.infra;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CookieService {

    public void setCookie(HttpServletResponse response, String key, String value, int seconds) {
        Cookie cookie = new Cookie(key, value);
        cookie.setHttpOnly(true); // Segurança: impede que o JS do front acesse o cookie
        cookie.setSecure(false);  // Em produção (HTTPS), mude para true
        cookie.setMaxAge(seconds); // Tempo de vida do cookie
        cookie.setPath("/");      // Disponível em toda a aplicação
        response.addCookie(cookie);
    }

    public String getCookie(HttpServletRequest request, String key) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> key.equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .findAny()
                    .orElse(null);
        }
        return null;
    }

    public void deleteCookie(HttpServletResponse response, String key) {
        Cookie cookie = new Cookie(key, null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(500); // Expira na hora
        response.addCookie(cookie);
    }
}
