package com.aluracursos.foro_hub.domain.topico;

import com.aluracursos.foro_hub.domain.curso.Curso;
import com.aluracursos.foro_hub.domain.curso.CursoRepository;
import com.aluracursos.foro_hub.domain.topico.dto.DatosActualizarTopico;
import com.aluracursos.foro_hub.domain.topico.dto.DatosListadoTopicos;
import com.aluracursos.foro_hub.domain.topico.dto.DatosRegistroTopico;
import com.aluracursos.foro_hub.domain.topico.dto.TopicoRespuesta;
import com.aluracursos.foro_hub.domain.usuario.Usuario;
import com.aluracursos.foro_hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;



    public void registrarTopico(DatosRegistroTopico datos) {
        // Validar duplicados
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new IllegalArgumentException("El tópico ya existe con el mismo título y mensaje.");
        }

        System.out.println("datos del autor "+datos.autor()+" y del curso"+datos.curso());
        // Buscar entidades relacionadas
        Usuario autor = usuarioRepository.findById(datos.autor())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado."));
        System.out.println("se encontro autor" + autor);
        Curso curso = cursoRepository.findById(datos.curso())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado."));

        System.out.println("se encontro curso"+curso);
        // Crear y guardar el tópico
        Topico topico = new Topico(datos.titulo(), datos.mensaje(), autor, curso);
        System.out.println("topico que se va a guardar"+topico);
        topicoRepository.save(topico);
    }



    public TopicoRespuesta obtenerTopicoPorId(Long id) {
        // Buscar el tópico en la base de datos
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El tópico con ID " + id + " no existe"));

        // Mapear los datos a un DTO de respuesta
        return new TopicoRespuesta(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }

    public void actualizarTopico(DatosActualizarTopico datos) {
        // Buscar el tópico en la base de datos
        Topico topico = topicoRepository.findById(datos.id())
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado."));

        // Validar duplicados
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new IllegalArgumentException("Otro tópico con el mismo título y mensaje ya existe.");
        }

        // Actualizar los datos del tópico
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());

        // Guardar el tópico actualizado
        topicoRepository.save(topico);
    }

    public void eliminarTopico(Long id) {
        // Verificar si el tópico existe
        if (!topicoRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("El tópico con el ID proporcionado no existe.");
        }

        // Eliminar el tópico
        topicoRepository.deleteById(id);
    }

}
