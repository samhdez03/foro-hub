package com.aluracursos.foro_hub.domain.usuario;

import com.aluracursos.foro_hub.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "email", unique = true)
    private String email;

    private String contrasena;

    @ManyToMany
    @JoinTable(
            name = "usuario_perfil", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "usuario_id"), // Columna que referencia a Usuario
            inverseJoinColumns = @JoinColumn(name = "perfil_id") // Columna que referencia a Perfil
    )
    private List<Perfil> perfiles;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aquí debes devolver las autoridades del usuario, por ejemplo:
        // Supongamos que el usuario tiene un rol "ROLE_USER"
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email; // El email se utiliza como el "username"
    }

    @Override
    public String getPassword() {
        return this.contrasena; // Suponiendo que 'contrasena' es el campo para la contraseña
    }

    public String getLogin() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
