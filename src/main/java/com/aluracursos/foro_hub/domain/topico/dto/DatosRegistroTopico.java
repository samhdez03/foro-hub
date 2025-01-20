package com.aluracursos.foro_hub.domain.topico.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank String titulo, // El título no puede ser nulo ni vacío
        @NotBlank String mensaje, // El mensaje no puede ser nulo ni vacío
        @NotNull Long autor, // ID del autor (usuario)
        @NotNull Long curso // ID del curso
) {
}


