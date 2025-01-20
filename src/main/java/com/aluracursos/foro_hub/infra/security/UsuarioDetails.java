package com.aluracursos.foro_hub.infra.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

public class UsuarioDetails extends User {

    private String email;


    public UsuarioDetails(String email, String password, Collection<? extends GrantedAuthority> authorities) {


        super(email, password, authorities);  // Utilizamos email como el 'username' aquí
        this.email = email;
    }

    @Override
    public String getUsername() {
        return email;  // Devuelve el correo electrónico como el "username"
    }

    // Si necesitas agregar otros detalles específicos del usuario, lo puedes hacer aquí.
}
