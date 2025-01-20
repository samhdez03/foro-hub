package com.aluracursos.foro_hub.domain.usuario;

import com.aluracursos.foro_hub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
