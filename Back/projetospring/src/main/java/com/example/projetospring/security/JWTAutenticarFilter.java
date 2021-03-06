package com.example.projetospring.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.projetospring.model.Usuario;
import com.example.projetospring.model.UsuarioData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 600_000 * 3;

    public static final String TOKEN_SENHA = "9ba23913-3830-49db-8d86-716d19943af1";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getUsername(),
                    usuario.getPassword(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuário", e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UsuarioData usuarioData = (UsuarioData) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(usuarioData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));
        String str = "{\"token\":" + token + "}";
        JSONObject jsonObject = new JSONObject(str);
        response.setHeader("acces_token", token);
        response.getWriter().write(token);
        response.getWriter().flush();

    }
}