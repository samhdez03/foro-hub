package com.aluracursos.foro_hub.infra.security;


import com.aluracursos.foro_hub.domain.usuario.Usuario;
import com.aluracursos.foro_hub.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // obtener token del header
        var authHeader = request.getHeader("Authorization");
         if (authHeader !=null ){
            var token = authHeader.replace("Bearer","").trim();
            var subject = tokenService.getSubject(token);
            if (subject!=null){
                //token valido
                var usuario = usuarioRepository.findByEmail(subject);
                var authentication= new UsernamePasswordAuthenticationToken(usuario,null,
                        usuario.getAuthorities()); //forzamos inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }
        filterChain.doFilter(request, response);

    }
}