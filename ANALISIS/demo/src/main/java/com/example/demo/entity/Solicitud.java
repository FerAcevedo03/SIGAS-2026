package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    @Column(unique = true, nullable = false, length = 18)
    private String codigoSeguimiento;

    @Column(nullable = false)
    private String nombreSolicitante;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    private String estado = "REGISTRADA";

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
    }
}