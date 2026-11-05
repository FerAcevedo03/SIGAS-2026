package com.example.demo.controller;

import com.example.demo.entity.Solicitud;
import com.example.demo.service.SolicitudService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    // --- RUTAS PARA REGISTRO ---
    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("solicitud", new Solicitud());
        return "registro"; 
    }

    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute Solicitud solicitud, Model model) {
        Solicitud nueva = solicitudService.registrar(solicitud);
        model.addAttribute("codigoSeguimiento", nueva.getCodigoSeguimiento());
        model.addAttribute("solicitud", new Solicitud()); // Limpia el formulario
        return "registro"; 
    }

    // --- RUTAS PARA CONSULTA ---
    @GetMapping("/consulta")
    public String mostrarConsulta() {
        return "consulta";
    }

    @PostMapping("/consulta")
    public String procesarConsulta(@RequestParam String codigo, Model model) {
        Optional<Solicitud> sol = solicitudService.consultarPorCodigo(codigo);
        if (sol.isPresent()) {
            model.addAttribute("solicitudEncontrada", sol.get());
        } else {
            model.addAttribute("error", "No se encontró ninguna solicitud con el código ingresado.");
        }
        model.addAttribute("codigoBuscado", codigo);
        return "consulta";
    }
}