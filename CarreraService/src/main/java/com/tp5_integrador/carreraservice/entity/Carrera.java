package com.tp5_integrador.carreraservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NOMBRE",unique=true)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrera")
    private Set<Inscripcion> estudiantes;

    public Carrera() {
        this.estudiantes = new HashSet<>();
    }

    public Carrera(String nombre) {
        this();
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Inscripcion> getEstudiantes() {
        return estudiantes;
    }

    public void addInscripciones(Inscripcion i) {
        this.estudiantes.add(i);
    }

    @Override
    public String toString() {
        return nombre +
                " - ID: " + id +
                " - Estudiantes: " + estudiantes.size();
    }
}