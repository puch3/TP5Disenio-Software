package com.tp5_integrador.inscripcionservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp5_integrador.inscripcionservice.entity.Inscripcion;
import com.tp5_integrador.inscripcionservice.repository.InscripcionRepository;

@Service
public class InscripcionService {

    // Instancia del repositorio de Inscripcion
	private final InscripcionRepository inscripcionReposirory;

    // Constructor que inicializa el repositorio
    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionReposirory = inscripcionRepository;
    }


    public Inscripcion persist(Inscripcion inscripcion) {
        return InscripcionRepository.save(inscripcion);
    }

    public Inscripcion merge(Inscripcion inscripcion) {
        return InscripcionRepository.save(inscripcion);
    }

    public void delete(Inscripcion inscripcion) {
        inscripcionRepository.delete(inscripcion);
    }

    public List<Inscripcion> findAll() {
        return InscripcionRepository.findAll();
    }
    // Método para encontrar una Inscripcion por ID
    public Inscripcion findById(Long ID) {
        return InscripcionRepository.findById(ID).orElse(null);
    }
    
    public Inscripcion guardarInscripcion(Inscripcion Inscripcion) {
        Inscripcion inscripcionAux = new Inscripcion(
                Inscripcion.getEstudiante(),
                Inscripcion.getCarrera(),
                Inscripcion.getFechaAlta()
        );

        return InscripcionRepository.save(inscripcionAux);
    }
}
