package com.aluracursos.foro_hub.domain.usuario;

import com.aluracursos.foro_hub.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
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
}
