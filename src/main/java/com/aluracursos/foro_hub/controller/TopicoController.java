package com.aluracursos.foro_hub.controller;

import com.aluracursos.foro_hub.domain.topico.TopicoRepository;
import com.aluracursos.foro_hub.domain.topico.TopicoService;
import com.aluracursos.foro_hub.domain.topico.dto.DatosActualizarTopico;
import com.aluracursos.foro_hub.domain.topico.dto.DatosListadoTopicos;
import com.aluracursos.foro_hub.domain.topico.dto.DatosRegistroTopico;
import com.aluracursos.foro_hub.domain.topico.dto.TopicoRespuesta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        topicoService.registrarTopico(datos);
        return ResponseEntity.status(201).body("Tópico registrado con éxito.");
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoDeMedicos(@PageableDefault(size = 10, sort={"fechaCreacion"}) Pageable paginacion){
        //return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTopico(@PathVariable Long id) {
        try {
            TopicoRespuesta topico = topicoService.obtenerTopicoPorId(id);
            return ResponseEntity.ok(topico);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarTopico datos) {
        // Validar que el ID en la URL coincida con el ID del cuerpo
        if (!id.equals(datos.id())) {
            return ResponseEntity.badRequest().body("El ID del cuerpo no coincide con el ID de la URL.");
        }

        // Actualizar el tópico
        topicoService.actualizarTopico(datos);
        return ResponseEntity.ok("Tópico actualizado con éxito.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        try {
            topicoService.eliminarTopico(id);
            return ResponseEntity.ok("Tópico eliminado con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}