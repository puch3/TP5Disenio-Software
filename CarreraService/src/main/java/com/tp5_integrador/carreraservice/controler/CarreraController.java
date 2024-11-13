package com.tp5_integrador.carreraservice.controler;

import com.tp5_integrador.carreraservice.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.tp5_integrador.Carreraservice.entity.Carrera;


import java.util.List;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {
    private final CarreraService CarreraService;

    @Autowired
    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> obtenerEstudiantePorDNI(@PathVariable Long dni) {
    	Carrera carrera = carreraService.findById(dni);
        return ResponseEntity.ok(Carrera);
    }

    @PostMapping
    public ResponseEntity<Carrera> crearEstudiante(@RequestBody Carrera carrera) {
    	Carrera carreraAux = carreraService.guardarCarrera(carrera);
        return new ResponseEntity<Carrera>(carreraAux, HttpStatus.CREATED);
    }
}
