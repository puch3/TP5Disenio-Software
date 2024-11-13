package com.tp5_integrador.carreraservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp5_integrador.carreraservice.entity.Carrera;
import com.tp5_integrador.carreraservice.repository.CarreraRepository;

@Service
public class CarreraService {

    // Instancia del repositorio de Inscripcion
	private final CarreraRepository carreraRepository;

    // Constructor que inicializa el repositorio
    @Autowired
    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }


    public Carrera persist(Carrera carrera) {
        return CarreraRepository.save(carrera);
    }

    public Carrera merge(Carrera carrera) {
        return CarreraRepository.save(carrera);
    }

    public void delete(Carrera carrera) {
    	carreraRepository.delete(carrera);
    }

    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }
    // Método para encontrar una Inscripcion por ID
    public Carrera findById(Long ID) {
        return CarreraRepository.findById(ID).orElse(null);
    }
    
    public Carrera guardarCarrera(Carrera carrera) {
    	Carrera carreraAux = new Carrera(
        		Carrera.getombre()
        );

        return CarreraRepository.save(carreraAux);
    }
}
