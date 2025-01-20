package com.aluracursos.foro_hub.domain.topico.dto;

import java.time.LocalDateTime;

public record TopicoRespuesta(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {
}
