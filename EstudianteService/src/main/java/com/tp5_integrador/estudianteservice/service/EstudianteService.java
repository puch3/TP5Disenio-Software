package com.tp5_integrador.estudianteservice.service;

import com.tp5_integrador.estudianteservice.entity.Estudiante;
import com.tp5_integrador.estudianteservice.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante findByDNI(Long DNI) {
        return estudianteRepository.findByDNI(DNI);
    }

    public Estudiante persist(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante merge(Estudiante estudiante) {
        return estudianteRepository.save(estudiante); // save maneja persistencia y merge
    }

    public void delete(Estudiante estudiante) {
        estudianteRepository.delete(estudiante);
    }

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public List<Estudiante> findAllOrderByName() {
        return estudianteRepository.findAllOrderByName();
    }

    public Estudiante findById(Long LU) {
        return estudianteRepository.findById(LU).orElse(null);
    }

    public List<Estudiante> findAllByGenero(Character genero) {
        return estudianteRepository.findAllByGenero(genero);
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        Estudiante estudianteAux = new Estudiante(
                estudiante.getLU(),
                estudiante.getDni(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getFechaNacimiento(),
                estudiante.getGenero(),
                estudiante.getResidencia()
        );

        return estudianteRepository.save(estudianteAux);
    }
}