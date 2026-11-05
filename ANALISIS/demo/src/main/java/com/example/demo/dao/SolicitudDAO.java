package com.example.demo.dao;

import com.example.demo.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SolicitudDAO extends JpaRepository<Solicitud, Long> {
    Optional<Solicitud> findByCodigoSeguimiento(String codigoSeguimiento);
}