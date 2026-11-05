package com.example.demo.dao;

import com.example.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNumeroDocumento(String numeroDocumento);
}