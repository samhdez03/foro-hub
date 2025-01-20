package com.aluracursos.foro_hub.domain.curso;

import com.aluracursos.foro_hub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
