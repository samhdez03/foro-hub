package com.aluracursos.foro_hub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Verificar si ya existe un tópico con el mismo título y mensaje
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
