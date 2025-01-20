package com.aluracursos.foro_hub.domain.topico.dto;

import com.aluracursos.foro_hub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
