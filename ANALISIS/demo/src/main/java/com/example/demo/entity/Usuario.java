package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 15, unique = true)
    private String numeroDocumento;

    @Column(length = 140, nullable = false)
    private String nombreCompleto;

    @Column(length = 160)
    private String correo;

    @Column(length = 20)
    private String telefono;
}