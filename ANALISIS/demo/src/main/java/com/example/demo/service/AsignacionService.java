package com.example.demo.service;

import com.example.demo.dao.SolicitudDAO;
import com.example.demo.entity.Solicitud;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class AsignacionService {

    private final SolicitudDAO solicitudDAO;

    public AsignacionService(SolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }

    @Transactional
    public boolean asignarSolicitud(String codigoSeguimiento, String nuevaArea) {
        Optional<Solicitud> solicitudOpt = solicitudDAO.findByCodigoSeguimiento(codigoSeguimiento);

        if (solicitudOpt.isPresent()) {
            Solicitud solicitud = solicitudOpt.get();
            solicitud.setEstado("ASIGNADA");
            // Aquí va la lógica para vincular la solicitud con la entidad Area.
            solicitudDAO.save(solicitud);
            return true;
        }
        return false;
    }
}