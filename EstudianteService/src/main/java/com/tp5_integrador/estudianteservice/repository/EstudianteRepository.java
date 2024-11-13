package com.tp5_integrador.estudianteservice.repository;

import com.tp5_integrador.estudianteservice.entity.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Estudiante findByDNI(Long dni);

    @Query("SELECT e FROM Estudiante e ORDER BY e.nombre")
    List<Estudiante> findAllOrderByName();

    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    List<Estudiante> findAllByGenero(Character genero);
}
