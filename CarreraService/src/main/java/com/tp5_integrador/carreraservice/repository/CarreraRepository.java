package com.tp5_integrador.carreraservice.repository;

import com.tp5_integrador.carreraservice.entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
	   	public Carrera findByNombre(String nombre);

	    @Query("SELECT c FROM Carrera c JOIN c.estudiantes ins WHERE ins.estudiante.residencia = :residencia AND c = :carrera")
	    public List<Estudiante> getEstudiantesByResidencia(String residencia, Carrera carrera);

	    @Query("SELECT c FROM Carrera c ORDER BY SIZE(c.estudiantes) DESC")
	    public List<Carrera> carrerasSegunInscriptos();
}
