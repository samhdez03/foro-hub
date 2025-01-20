package com.aluracursos.foro_hub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje
) {
}
