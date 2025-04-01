package com.elias.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elias.estudiantes.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
