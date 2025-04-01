package com.elias.estudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elias.estudiantes.dto.EstudianteDTO;
import com.elias.estudiantes.entity.Estudiante;
import com.elias.estudiantes.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repo;
    
    public List<Estudiante> obtenerTodos() {
        return repo.findAll();
    }
    

    public Estudiante crear(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    public Estudiante actualizar(Long id, EstudianteDTO dto) {
        Estudiante est = repo.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        est.setNombre(dto.getNombre());
        est.setCorreo(dto.getCorreo());
        est.setEdad(dto.getEdad());
        return repo.save(est);
    }

    public Estudiante obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
