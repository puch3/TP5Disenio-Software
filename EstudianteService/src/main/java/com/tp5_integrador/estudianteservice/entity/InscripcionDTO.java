package com.tp5_integrador.estudianteservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class InscripcionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ESTUDIANTE_ID", nullable = false)
    private Estudiante estudianteId;

    @Column(name="CARRERA_ID", nullable=false)
    private Long carreraId;

    @Column(name="GRADUADO", nullable=false)
    private boolean graduado;

    public InscripcionDTO() {}

    public InscripcionDTO(Long id, Estudiante estudianteId, Long carreraId) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.carreraId = carreraId;
        this.graduado = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Estudiante estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }
}
