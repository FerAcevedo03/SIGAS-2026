package com.example.demo.service;

import com.example.demo.dao.SolicitudDAO;
import com.example.demo.entity.Solicitud;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.util.Optional;

@Service
public class SolicitudService {
    
    private final SolicitudDAO solicitudDAO;

    public SolicitudService(SolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }

    @Transactional
    public Solicitud registrar(Solicitud solicitud) {
        // Genera el código único (Ej: SG-2026-A1B2)
        solicitud.setCodigoSeguimiento("SG-2026-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase());
        return solicitudDAO.save(solicitud);
    }

    public Optional<Solicitud> consultarPorCodigo(String codigo) {
        return solicitudDAO.findByCodigoSeguimiento(codigo);
    }
}