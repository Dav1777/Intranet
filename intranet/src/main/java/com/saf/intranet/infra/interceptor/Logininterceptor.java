package com.saf.intranet.infra.interceptor;

import com.saf.intranet.infra.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class Logininterceptor implements HandlerInterceptor {

    private final CookieService cookieService;

    public Logininterceptor(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (cookieService.getCookie(request, "usuario_logado") != null) {
            //response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}
