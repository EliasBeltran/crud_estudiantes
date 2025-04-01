package com.elias.estudiantes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.elias.estudiantes.dto.EstudianteDTO;
import com.elias.estudiantes.entity.Estudiante;
import com.elias.estudiantes.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante(null, dto.getNombre(), dto.getCorreo(), dto.getEdad());
        return new ResponseEntity<>(service.crear(estudiante), HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Estudiante>> crearVarios(@RequestBody List<EstudianteDTO> estudiantesDto) {
        List<Estudiante> estudiantes = new ArrayList<>();

        for (EstudianteDTO dto : estudiantesDto) {
            Estudiante estudiante = new Estudiante(null, dto.getNombre(), dto.getCorreo(), dto.getEdad());
            estudiantes.add(service.crear(estudiante));
        }

        return new ResponseEntity<>(estudiantes, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
